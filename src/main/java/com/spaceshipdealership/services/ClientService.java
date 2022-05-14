package com.spaceshipdealership.services;

import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.enums.RaceEnum;
import com.spaceshipdealership.model.exceptions.ListErrorException;

import java.io.*;
import java.util.*;

public class ClientService implements CSVService<Set<Client>> {
    private static final String FILE_PATH = "data/Clients.csv";
    private static ClientService INSTANCE;
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
        if (this.clients.isEmpty()) {
            throw new ListErrorException("clients");
        } else {
            for (Client client : this.clients) {
                System.out.println(i + " - " + client.toString());
                i++;
            }
        }
    }

    public Client addClient(Scanner scanner) {
        System.out.println("First Name,Last Name,Race,Holophone Address,Client ID,Energy Credits");
        Client newClient;
        String[] splitLine = scanner.next().split(",");
        newClient = new Client(splitLine[0], splitLine[1], RaceEnum.valueOf(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
        this.clients.add(newClient);
        CSVwrite(this.clients);
        return newClient;
    }

    public Client getClientByIndex(int index) {
        // workaround to select by index in a set
        List<Client> newClients = new ArrayList<>(this.clients);
        return newClients.get(index);
    }

    public Client removeClient(int index) {
        Client clientToRemove = getClientByIndex(index);
        this.clients.remove(clientToRemove);
        CSVwrite(this.clients);
        return clientToRemove;
    }

    public void updateBalance(Client client, int newBalance) {
        for (Client clientIter : this.clients) {
            if (clientIter.equals(client)) {
                client.setEnergyCredits(newBalance);
            }
        }
        CSVwrite(this.clients);
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
