package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Spaceship.Military.Carrier.Carrier;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrierService implements CSVService<List<Carrier>> {
    private static CarrierService INSTANCE;

    private static final String FILE_PATH = "data/Carriers.csv";

    private List<Carrier> carriers;

    private CarrierService() {
        this.carriers = CSVread();
    }

    public static CarrierService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarrierService();
        }
        return INSTANCE;
    }

    public void printCarriers() {
        Integer i = 0;
        this.carriers = CSVread();
        if (this.carriers.isEmpty()) {
            throw new ListErrorException("carriers");
        } else {
            for (Carrier carrier : this.carriers) {
                System.out.println(i + " - " + carrier.toString());
                i++;
            }
        }
    }

    public Carrier addCarrier(Scanner scanner) {
        System.out.println("Model Name,Price,Propulsion Type,Power Output,Shield Capacity,Guns No.");
        Carrier newCarrier = null;
        try {
            String[] splitLine = scanner.next().split(",");
            newCarrier = new Carrier(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));
            this.carriers.add(newCarrier);
            CSVwrite(this.carriers);
        } catch (RuntimeException e) {
            System.out.println("Invalid option.");
        }
        return newCarrier;
    }

    public Carrier getCarrierByIndex(int shipIndex) {
        return this.carriers.get(shipIndex);
    }

    public Carrier removeCarrierByIndex(int shipIndex) {
        Carrier shipToRemove = getCarrierByIndex((shipIndex));
        this.carriers.remove(shipToRemove);
        CSVwrite(this.carriers);
        return shipToRemove;
    }

    @Override
    public List<Carrier> CSVread() {
        List<Carrier> carriers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            //skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                carriers.add(new Carrier(splitLine[0], Integer.parseInt(splitLine[1]), PropulsionTypeEnum.valueOf(splitLine[2]), Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return carriers;
    }

    @Override
    public void CSVwrite(List<Carrier> carriers) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("Model Name,Price,Propulsion Type,Power Output,Shield Capacity,Spacemarines Capacity,Spacecraft Capacity");
            textWriter.newLine();
            for (Carrier carrier : carriers) {
                textWriter.write(carrier.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}