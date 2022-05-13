package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Person.Staff.Staff;
import com.spaceshipdealership.model.enums.DepartmentEnum;
import com.spaceshipdealership.model.enums.RaceEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StaffService implements CSVService<Set<Staff>> {
    private static StaffService INSTANCE;
    private static final String FILE_PATH = "data/Staff.csv";
    private Set<Staff> staff;

    private StaffService() {

    }

    public static StaffService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StaffService();
        }
        return INSTANCE;
    }

    public void printStaff() {
        Integer i = 1;
        this.staff = CSVread();
        for (Staff staff : this.staff) {
            System.out.println(i.toString() + " - " + staff.toString());
            i++;
        }
    }

    public Staff getStaffByIndex(int index) {
        // workaround to select by index in a set
        List<Staff> newStaff = new ArrayList<>(this.staff);
        return newStaff.get(index);
    }

    public void removeStaff(int index) {
        // workaround to remove by index in a set
        List<Staff> newStaff = new ArrayList<>(this.staff);
        newStaff.remove(index);
        this.staff = Set.copyOf(newStaff);
        CSVwrite(staff);
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
            for (Staff staffPers : staff) {
                textWriter.write(staffPers.objectToCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
