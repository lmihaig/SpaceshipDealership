package com.spaceshipdealership.services;

import com.spaceshipdealership.exceptions.InsufficientFunds;
import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.enums.RaceEnum;

import java.io.*;
import java.util.*;

public class ClientService implements CSVService<Set<Client>> {
    private static ClientService INSTANCE;

    private static final String FILE_PATH = "data/Client.csv";
    private Set<Client> clients;

    private ClientService() {
        this.clients = CSVread();
    }

    public static ClientService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClientService();
        }
        return INSTANCE;
    }

    public void printClients() {
        Integer i = 0;
        this.clients = CSVread();
        for (Client client : this.clients) {
            System.out.println(i.toString() + " - " + client.toString());
            i++;
        }
    }

    public void addClient(Scanner scanner) {

        this.clients.add(new Client());
        CSVwrite(this.clients);
    }

    public Client getClientByIndex(int index) {
        // workaround to select by index in a set
        List<Client> newClients = new ArrayList<>(this.clients);
        return newClients.get(index);
    }

    public void removeClient(int index) {
        // workaround to remove by index in a set
        List<Client> newClients = new ArrayList<>(this.clients);
        newClients.remove(index);
        this.clients = Set.copyOf(newClients);
        CSVwrite(this.clients);
    }

    public void buyShip(Client client, Spaceship ship) {
        try {
            int newBalance = client.getEnergyCredits() - ship.getPrice();
            if (newBalance < 0) {
                throw new InsufficientFunds();
            } else {
                client.setEnergyCredits(newBalance);
                //TODO: remove spaceship pls
                CSVwrite(clients);
            }
        } catch (InsufficientFunds e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Client> CSVread() {
        Set<Client> clients = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            // skip CSV headers
            bufferedReader.readLine();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                clients.add(new Client(splitLine[0], splitLine[1], RaceEnum.valueOf(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5])));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to read from file.");
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void CSVwrite(Set<Client> clients) {
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(FILE_PATH));
            textWriter.write("First Name,Last Name,Race,Holophone Address,Client ID,Energy Credits");
            textWriter.newLine();
            for (Client client : clients) {
                textWriter.write(client.objectToCSV());
                textWriter.newLine();
            }
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
