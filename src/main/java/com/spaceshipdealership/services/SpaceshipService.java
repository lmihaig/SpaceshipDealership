package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.exceptions.InsufficientFundsException;

import java.util.Scanner;

public class SpaceshipService {
    private static SpaceshipService INSTANCE;
    FreighterService freighterService = FreighterService.getInstance();
    ShuttleService shuttleService = ShuttleService.getInstance();
    CarrierService carrierService = CarrierService.getInstance();
    FighterService fighterService = FighterService.getInstance();

    ClientService clientService = ClientService.getInstance();

    private SpaceshipService() {
    }

    public static SpaceshipService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SpaceshipService();
        }
        return INSTANCE;
    }

    public int printShips(Scanner scanner) {
        int option;
        System.out.println("""
                1.Freighters
                2.Shuttles
                3.Carriers
                4.Fighters""");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> freighterService.printFreighters();
            case 2 -> shuttleService.printShuttles();
            case 3 -> carrierService.printCarriers();
            case 4 -> fighterService.printFighters();
            default -> System.out.println("Invalid option.");
        }
        return option;
    }

    public Spaceship addShip(Scanner scanner) {
        int option;
        Spaceship newShip = null;
        System.out.println("""
                1.Freighters
                2.Shuttles
                3.Carriers
                4.Fighters""");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> newShip = freighterService.addFreighter(scanner);
            case 2 -> newShip = shuttleService.addShuttle(scanner);
            case 3 -> newShip = carrierService.addCarrier(scanner);
            case 4 -> newShip = fighterService.addFighter(scanner);
            default -> System.out.println("Invalid option.");
        }
        return newShip;
    }

    public Spaceship removeShip(Scanner scanner) {
        int option = printShips(scanner);
        int shipToRemove = scanner.nextInt();
        return removeShipByOption(option, shipToRemove);
    }

    public Spaceship removeShipByOption(int shipClass, int shipIndex) {
        Spaceship newShip = null;
        switch (shipClass) {
            case 1 -> newShip = freighterService.removeFreighterByIndex(shipIndex);
            case 2 -> newShip = shuttleService.removeShuttleByIndex(shipIndex);
            case 3 -> newShip = carrierService.removeCarrierByIndex(shipIndex);
            case 4 -> newShip = fighterService.removeFighterByIndex(shipIndex);
            default -> System.out.println("Invalid option.");
        }
        return newShip;
    }

    public Spaceship getShipByIndex(int shipClass, int shipIndex) {
        Spaceship newShip = null;
        switch (shipClass) {
            case 1 -> newShip = freighterService.getFreighterByIndex(shipIndex);
            case 2 -> newShip = shuttleService.getShuttleByIndex(shipIndex);
            case 3 -> newShip = carrierService.getCarrierByIndex(shipIndex);
            case 4 -> newShip = fighterService.getFighterByIndex(shipIndex);
            default -> System.out.println("Invalid option.");
        }
        return newShip;
    }

    public Spaceship buyShip(Client client, Scanner scanner) {
        int option = printShips(scanner);
        int shipToBuy = scanner.nextInt();
        Spaceship ship = getShipByIndex(option, shipToBuy);
        int newBalance = client.getEnergyCredits() - ship.getPrice();
        if (newBalance < 0) {
            throw new InsufficientFundsException();
        } else {
            Client newClient = new Client(client);
            newClient.setEnergyCredits(newBalance);
            clientService.updateClient(client, newClient);
            removeShipByOption(option, shipToBuy);
            System.out.println("New balance: " + newBalance);
            return ship;
        }
    }
}
