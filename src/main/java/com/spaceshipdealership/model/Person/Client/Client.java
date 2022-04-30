package com.spaceshipdealership.model.Person.Client;

import com.spaceshipdealership.model.Person.Person;
import com.spaceshipdealership.model.enums.RaceEnum;

public class Client extends Person {
    private int clientID;
    private int energyCredits;


    public Client(String firstName, String lastName, RaceEnum race, String holophoneAdr, int clientID, int energyCredits) {
        super(firstName, lastName, race, holophoneAdr);
        this.clientID = clientID;
        this.energyCredits = energyCredits;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getEnergyCredits() {
        return energyCredits;
    }

    public void setEnergyCredits(int energyCredits) {
        this.energyCredits = energyCredits;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", energyCredits=" + energyCredits +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", holophoneAdr='" + holophoneAdr + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
