package com.spaceshipdealership.model.Person;

import com.spaceshipdealership.model.enums.RaceEnum;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String holophoneAdr;
    protected RaceEnum race;

    public Person(String firstName, String lastName, RaceEnum race, String holophoneAdr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.race = race;
        this.holophoneAdr = holophoneAdr;
    }

    public String getHolophoneAdr() {
        return holophoneAdr;
    }

    public void setHolophoneAdr(String holophoneAdr) {
        this.holophoneAdr = holophoneAdr;
    }

    public RaceEnum getRace() {
        return race;
    }

    public void setRace(RaceEnum race) {
        this.race = race;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", holophoneAdr='" + holophoneAdr + '\'' +
                '}';
    }
}
