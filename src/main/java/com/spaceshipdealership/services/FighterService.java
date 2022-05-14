package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Spaceship.Military.Fighter.Fighter;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FighterService implements CSVService<List<Fighter>> {
    private static final String FILE_PATH = "data/Fighters.csv";
    private static FighterService INSTANCE;
    private List<Fighter> fighters;

    private FighterService() {
        this.fighters = CSVread();
    }

    public static FighterService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FighterService();
        }
        return INSTANCE;
    }

    public void printFighters() {
        Integer i = 0;
        this.fighters = CSVread();
        if (this.fighters.isEmpty()) {
            throw new ListErrorException("fighters");
        } else {
            for (Fighter fighter : this.fighters) {
                System.out.println(i + " - " + fighter.toString());
                i++;
            }
        }
    }

    public Fighter addFighter(Scanner scanner) {
        System.out.println("Model Name,Price,Propulsion Type,Power Output,Shield Capacity,Guns No.");
        Fighter newFighter = null;
        try {
            String[] splitLine = scanner.next().split(",");
            newFighter = new Fighter(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
            this.fighters.add(newFighter);
            CSVwrite(this.fighters);
        } catch (RuntimeException e) {
            System.out.println("Invalid option.");
        }
        return newFighter;
    }

    public Fighter getFighterByIndex(int shipIndex) {
        return this.fighters.get(shipIndex);
    }

    public Fighter removeFighterByIndex(int shipIndex) {
        Fighter shipToRemove = getFighterByIndex((shipIndex));
        this.fighters.remove(shipToRemove);
        CSVwrite(this.fighters);
        return shipToRemove;
    }

    @Override
    public List<Fighter> CSVread() {
        List<Fighter> fighters = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            //skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                fighters.add(new Fighter(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return fighters;
    }

    @Override
    public void CSVwrite(List<Fighter> fighters) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("Model Name,Price,Propulsion Type,Power Output,Shield Capacity,Guns No.");
            textWriter.newLine();
            for (Fighter fighter : fighters) {
                textWriter.write(fighter.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}