package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Person.Staff.Staff;
import com.spaceshipdealership.model.enums.DepartmentEnum;
import com.spaceshipdealership.model.enums.RaceEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;
import com.spaceshipdealership.model.exceptions.StaffRemovalException;

import java.io.*;
import java.util.*;


public class StaffService implements CSVService<Set<Staff>> {
    private static StaffService INSTANCE;
    private static final String FILE_PATH = "data/Staff.csv";
    private Set<Staff> staff;

    private StaffService() {
        this.staff = CSVread();
    }

    public static StaffService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StaffService();
        }
        return INSTANCE;
    }

    public void printStaff() {
        int i = 0;
        this.staff = CSVread();
        if (this.staff.isEmpty()) {
            throw new ListErrorException("staff");
        } else {
            for (Staff staff : this.staff) {
                System.out.println(i + " - " + staff.toString());
                i++;
            }
        }
    }

    public Staff addStaff(Scanner scanner) {
        System.out.println("First Name,Last Name,Race,Holophone Address,Employee ID,Department,Salary");
        Staff newStaff;
        String[] splitLine = scanner.next().split(",");
        newStaff = new Staff(splitLine[0], splitLine[1], RaceEnum.valueOf(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), DepartmentEnum.fromString(splitLine[5]), Integer.parseInt(splitLine[6]));
        this.staff.add(newStaff);
        CSVwrite(this.staff);
        return newStaff;
    }

    public Staff getStaffByIndex(int index) {
        // workaround to select by index in a set
        List<Staff> newStaff = new ArrayList<>(this.staff);
        return newStaff.get(index);
    }

    public Staff removeStaff(int index, Staff staff) {
        Staff staffToRemove = getStaffByIndex(index);
        if (staff.equals(staffToRemove)) {
            throw new StaffRemovalException();
        }
        this.staff.remove(staffToRemove);
        CSVwrite(this.staff);
        return staffToRemove;
    }


    @Override
    public Set<Staff> CSVread() {
        Set<Staff> staff = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            // skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                staff.add(new Staff(splitLine[0], splitLine[1], RaceEnum.valueOf(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), DepartmentEnum.fromString(splitLine[5]), Integer.parseInt(splitLine[6])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public void CSVwrite(Set<Staff> staff) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("First Name,Last Name,Race,Holophone Address,Employee ID,Department,Salary");
            textWriter.newLine();
            for (Staff staffPers : staff) {
                textWriter.write(staffPers.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
