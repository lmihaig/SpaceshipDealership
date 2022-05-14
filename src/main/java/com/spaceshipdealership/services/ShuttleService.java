package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Spaceship.Civillian.Shuttle.Shuttle;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShuttleService implements CSVService<List<Shuttle>> {
    private static final String FILE_PATH = "data/Shuttles.csv";
    private static ShuttleService INSTANCE;
    private List<Shuttle> shuttles;

    private ShuttleService() {
        this.shuttles = CSVread();
    }

    public static ShuttleService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShuttleService();
        }
        return INSTANCE;
    }

    public void printShuttles() {
        Integer i = 0;
        this.shuttles = CSVread();
        if (this.shuttles.isEmpty()) {
            throw new ListErrorException("shuttles");
        } else {
            for (Shuttle shuttle : this.shuttles) {
                System.out.println(i + " - " + shuttle.toString());
                i++;
            }
        }
    }

    public Shuttle addShuttle(Scanner scanner) {
        System.out.println("Model Name,Price,Propulsion Type,Power Output,FTL Speed,Passenger Capacity");
        Shuttle newShuttle = null;
        try {
            String[] splitLine = scanner.next().split(",");
            newShuttle = new Shuttle(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
            this.shuttles.add(newShuttle);
            CSVwrite(this.shuttles);
        } catch (RuntimeException e) {
            System.out.println("Invalid option.");
        }
        return newShuttle;
    }

    public Shuttle getShuttleByIndex(int shipIndex) {
        return this.shuttles.get(shipIndex);
    }

    public Shuttle removeShuttleByIndex(int shipIndex) {
        Shuttle shipToRemove = getShuttleByIndex((shipIndex));
        this.shuttles.remove(shipToRemove);
        CSVwrite(this.shuttles);
        return shipToRemove;
    }

    @Override
    public List<Shuttle> CSVread() {
        List<Shuttle> shuttles = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            //skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                shuttles.add(new Shuttle(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return shuttles;
    }

    @Override
    public void CSVwrite(List<Shuttle> shuttles) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("Model Name,Price,Propulsion Type,Power Output,FTL Speed,Passenger Capacity");
            textWriter.newLine();
            for (Shuttle shuttle : shuttles) {
                textWriter.write(shuttle.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}