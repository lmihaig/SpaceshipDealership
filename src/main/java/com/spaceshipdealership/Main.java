package com.spaceshipdealership;


import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.Person.Staff.Staff;
import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.exceptions.InsufficientFundsException;
import com.spaceshipdealership.model.exceptions.ListErrorException;
import com.spaceshipdealership.services.AuditService;
import com.spaceshipdealership.services.ClientService;
import com.spaceshipdealership.services.SpaceshipService;
import com.spaceshipdealership.services.StaffService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AuditService auditService = AuditService.getInstance();
        ClientService clientService = ClientService.getInstance();
        StaffService staffService = StaffService.getInstance();
        SpaceshipService spaceshipService = SpaceshipService.getInstance();

        boolean running = true;
        boolean login = false;
        int loggedInAs = 0;
        int option;

        Client client = null;
        Staff staff = null;

        Spaceship ship;
        Client newClient;
        Staff newStaff;

        System.out.println("Hello there.");
        while (running) {
            if (!login) {
                System.out.println("""
                        Log in as:
                        1.Staff
                        2.Client
                        3.Exit""");
                loggedInAs = scanner.nextInt();
            }
            switch (loggedInAs) {
                case 1 -> {
                    if (!login) {
                        staffService.printStaff();
                        option = scanner.nextInt();
                        try {
                            staff = staffService.getStaffByIndex(option);
                            login = true;
                            auditService.AuditAuthentification(staff, "login");
                        } catch (Exception e) {
                            System.out.println("Invalid option.");
                            break;
                        }
                    }
                    System.out.println("""
                            1.List all clients
                            2.Add new client
                            3.Update client
                            4.Remove client
                            5.List ships
                            6.Add new ship
                            7.Remove ship
                            8.List all staff
                            9.Add staff
                            10.Remove staff
                            11.Log out
                            12.Exit""");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> {
                            try {
                                clientService.printClients();
                                auditService.AuditList(staff, "clients");
                            } catch (ListErrorException e) {
                                e.printStackTrace();
                            }
                        }
                        case 2 -> {
                            try {
                                newClient = clientService.addClient(scanner);
                                auditService.AuditStaffActions(staff, newClient, "added");
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 3 -> {
                            try {
                                clientService.printClients();
                                option = scanner.nextInt();
                                newClient = clientService.getClientByIndex(option);
                                auditService.AuditStaffActions(staff, newClient, "updated");
                                clientService.updateClient(newClient, clientService.createClient(scanner));
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 4 -> {
                            clientService.printClients();
                            option = scanner.nextInt();
                            try {
                                newClient = clientService.removeClient(option);
                                auditService.AuditStaffActions(staff, newClient, "removed");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 5 -> {
                            try {
                                spaceshipService.printShips(scanner);
                                auditService.AuditList(staff, "ships");
                            } catch (ListErrorException e) {
                                e.printStackTrace();
                            }
                        }
                        case 6 -> {
                            try {
                                ship = spaceshipService.addShip(scanner);
                                auditService.AuditStaffActions(staff, ship, "added");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 7 -> {
                            try {
                                ship = spaceshipService.removeShip(scanner);
                                auditService.AuditStaffActions(staff, ship, "removed");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 8 -> {
                            try {
                                staffService.printStaff();
                                auditService.AuditList(staff, "staff");
                            } catch (ListErrorException e) {
                                e.printStackTrace();
                            }
                        }
                        case 9 -> {
                            try {
                                newStaff = staffService.addStaff(scanner);
                                auditService.AuditStaffActions(staff, newStaff, "added");
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 10 -> {
                            staffService.printStaff();
                            option = scanner.nextInt();
                            try {
                                newStaff = staffService.removeStaff(option, staff);
                                auditService.AuditStaffActions(staff, newStaff, "removed");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Invalid option.");
                            }
                        }
                        case 11 -> {
                            login = false;
                            auditService.AuditAuthentification(staff, "logout");
                        }
                        case 12 -> {
                            System.out.println("Transmission terminated. Live long and prosper.");
                            running = false;
                            auditService.AuditAuthentification(staff, "exit");
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
                case 2 -> {
                    if (!login) {
                        clientService.printClients();
                        option = scanner.nextInt();
                        try {
                            client = clientService.getClientByIndex(option);
                            auditService.AuditAuthentification(client, "login");
                            login = true;
                        } catch (Exception e) {
                            System.out.println("Invalid option.");
                            break;
                        }
                    }
                    System.out.println("""
                            1.List ships
                            2.Buy a ship
                            3.Log out
                            4.Exit""");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> {
                            try {
                                spaceshipService.printShips(scanner);
                                auditService.AuditList(client, "ships");
                            } catch (ListErrorException e) {
                                e.printStackTrace();
                            }
                        }
                        case 2 -> {
                            try {
                                ship = spaceshipService.buyShip(client, scanner);
                                auditService.AuditClientBuy(client, ship);
                            } catch (InsufficientFundsException e) {
                                e.printStackTrace();
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                                System.out.println("Abort.");
                            }
                        }
                        case 3 -> {
                            login = false;
                            auditService.AuditAuthentification(client, "logout");
                        }
                        case 4 -> {
                            System.out.println("Transmission terminated. So long and thanks for all the fish.");
                            running = false;
                            auditService.AuditAuthentification(client, "exit");
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
                case 3 -> {
                    System.out.println("Transmission terminated. Until next time!");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}