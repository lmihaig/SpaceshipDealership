package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Spaceship.Civillian.Freighter.Freighter;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FreighterService implements CSVService<List<Freighter>> {
    private static final String FILE_PATH = "data/Freighters.csv";
    private static FreighterService INSTANCE;
    private List<Freighter> freighters;

    private FreighterService() {
        this.freighters = CSVread();
    }

    public static FreighterService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FreighterService();
        }
        return INSTANCE;
    }

    public void printFreighters() {
        Integer i = 0;
        this.freighters = CSVread();
        if (this.freighters.isEmpty()) {
            throw new ListErrorException("freighters");
        } else {
            for (Freighter freighter : this.freighters) {
                System.out.println(i + " - " + freighter.toString());
                i++;
            }
        }
    }

    public Freighter addFreighter(Scanner scanner) {
        System.out.println("Model Name,Price,Propulsion Type,Power Output,FTL Speed,Cargo Capacity");
        Freighter newFreighter = null;
        try {
            String[] splitLine = scanner.next().split(",");
            newFreighter = new Freighter(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
            this.freighters.add(newFreighter);
            CSVwrite(this.freighters);
        } catch (RuntimeException e) {
            System.out.println("Invalid option.");
        }
        return newFreighter;
    }

    public Freighter getFreighterByIndex(int shipIndex) {
        return this.freighters.get(shipIndex);
    }

    public Freighter removeFreighterByIndex(int shipIndex) {
        Freighter shipToRemove = getFreighterByIndex((shipIndex));
        this.freighters.remove(shipToRemove);
        CSVwrite(this.freighters);
        return shipToRemove;
    }

    @Override
    public List<Freighter> CSVread() {
        List<Freighter> freighters = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            //skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                freighters.add(new Freighter(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return freighters;
    }

    @Override
    public void CSVwrite(List<Freighter> freighters) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("Model Name,Price,Propulsion Type,Power Output,FTL Speed,Cargo Capacity");
            textWriter.newLine();
            for (Freighter freighter : freighters) {
                textWriter.write(freighter.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}