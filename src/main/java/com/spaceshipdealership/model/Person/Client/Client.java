package com.spaceshipdealership.model.Person.Client;

import com.spaceshipdealership.model.Person.Person;
import com.spaceshipdealership.model.enums.RaceEnum;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getClientID() == client.getClientID() && getEnergyCredits() == client.getEnergyCredits();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientID(), getEnergyCredits());
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

    public String objectToCSV() {
        return this.getFirstName() + "," + this.getLastName() + "," + this.getRace() + "," + this.getHolophoneAdr() + "," + this.getClientID() + "," + this.getEnergyCredits();
    }
}
