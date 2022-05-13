package com.spaceshipdealership;


import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.Person.Staff.Staff;
import com.spaceshipdealership.services.AuditService;
import com.spaceshipdealership.services.ClientService;
import com.spaceshipdealership.services.StaffService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AuditService auditService = AuditService.getInstance();
        ClientService clientService = ClientService.getInstance();
        StaffService staffService = StaffService.getInstance();

        boolean running = true;
        boolean login = false;
        int loggedInAs = 0;
        int option = 0;
        System.out.println("Hello there.");
        while (running) {
            if (!login) {
                System.out.println("Log in as: \n1.Staff\n2.Client\n3.Exit");
                loggedInAs = scanner.nextInt();
            }
            switch (loggedInAs) {
                case 1:
                    if (!login) {
                        staffService.printStaff();
                        option = scanner.nextInt();
                        try {
                            Staff staff = staffService.getStaffByIndex(option);
                            login = true;
                        } catch (Exception e) {
                            System.out.println("Invalid option.");
                            break;
                        }
                    }

                    System.out.println("1.List all clients\n2.Add new client\n3.Remove client\n4.List ships\n5.Add new ship\n6.Remove ship\n7.List all staff\n8.Add staff\n9.Remove staff\n10.Log out\n11.Exit");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            clientService.printClients();
                            break;
                        case 2:
                            break;
                        case 3:
                            clientService.printClients();
                            option = scanner.nextInt();
                            try {
                                clientService.removeClient(option);
                            } catch (Exception e) {
                                System.out.println("Invalid option.");
                                break;
                            }

                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 10:
                            login = false;
                            break;
                        case 11:
                            System.out.println("Transmission terminated. Live long and prosper.");
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;

                case 2:
                    if (!login) {
                        clientService.printClients();
                        option = scanner.nextInt();
                        try {
                            Client client = clientService.getClientByIndex(option);
                            login = true;
                        } catch (Exception e) {
                            System.out.println("Invalid option.");
                            login = false;
                            break;
                        }
                    }

                    System.out.println("1.List ships\n2.Buy a ship\n3.Log out\n4.Exit");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            login = false;
                            break;
                        case 4:
                            System.out.println("Transmission terminated. So long and thanks for all the fish.");
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Transmission terminated. Until next time!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    login = false;
                    break;
            }
        }
    }
}