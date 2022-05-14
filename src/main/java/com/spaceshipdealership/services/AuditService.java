package com.spaceshipdealership.services;


import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.Person.Person;
import com.spaceshipdealership.model.Person.Staff.Staff;
import com.spaceshipdealership.model.Spaceship.Spaceship;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AuditService {


    private static AuditService INSTANCE;

    private static final String FILE_PATH = "data/Audit.csv";

    private AuditService() {

    }

    public static AuditService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuditService();
        }
        return INSTANCE;
    }

    public void AuditAuthentification(Person obj, String action) {
        String text = switch (action) {
            case "login" ->
                    String.format("(%s) %s %s has logged in", obj.getClass().getSimpleName(), obj.getLastName(), obj.getFirstName());
            case "logout" ->
                    String.format("(%s) %s %s has logged out", obj.getClass().getSimpleName(), obj.getLastName(), obj.getFirstName());
            case "exit" ->
                    String.format("(%s) %s %s has exited the application", obj.getClass().getSimpleName(), obj.getLastName(), obj.getFirstName());
            default -> null;
        };
        AuditWrite(text);
    }

    public void AuditList(Person obj, String objectsToBeListed) {
        String text = String.format("(%s) %s %s has listed %s",
                obj.getClass().getSimpleName(), obj.getLastName(), obj.getFirstName(), objectsToBeListed);
        AuditWrite(text);
    }

    public void AuditStaffActions(Staff staff, Spaceship obj, String action) {
        if (!Objects.isNull(obj)) {
            String text = String.format("(Staff) %s %s has %s (%s) %s %s",
                    staff.getLastName(), staff.getFirstName(), action, obj.getClass().getSimpleName(), obj.getModelName(), obj.getPrice());
            AuditWrite(text);
        }
    }

    public void AuditStaffActions(Staff staff, Person obj, String action) {
        if (!Objects.isNull(obj)) {
            String text = String.format("(Staff) %s %s has %s (%s) %s %s",
                    staff.getLastName(), staff.getFirstName(), action, obj.getClass().getSimpleName(), obj.getLastName(), obj.getFirstName());
            AuditWrite(text);
        }
    }

    public void AuditClientBuy(Client client, Spaceship ship) {
        String text = String.format("(Client) %s %s has bought (%s) %s at %s CREDITS",
                client.getLastName(), client.getFirstName(), ship.getClass().getSimpleName(), ship.getModelName(), ship.getPrice());
        AuditWrite(text);
    }

    private void AuditWrite(String text) {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create audit file.");
                e.printStackTrace();
            }
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        text = formatter.format(date) + " - " + text;
        try {
            BufferedWriter textWriter = new BufferedWriter(new FileWriter(file, true));
            textWriter.write(text);
            textWriter.newLine();
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
