package com.spaceshipdealership;

import com.spaceshipdealership.model.Person.Client.Client;
import com.spaceshipdealership.model.enums.RaceEnum;

public class Main {
    public static void main(String[] args) {

        Client test = new Client("Bork", "Bjorkenson", RaceEnum.valueOf("BORG"), "1023015zl24", 100, 10000);
        System.out.println(test);
        test.setFirstName("maimuta");
        System.out.println(test.getRace());
    }
}