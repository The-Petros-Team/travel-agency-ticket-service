package com.bobocode.petros.ticketservice.entity.enumeration;

import java.util.concurrent.ThreadLocalRandom;

public enum FlightClassEnum {
    FIRST,
    BUSINESS,
    ECONOMY;

    public static FlightClassEnum getRandomFlightClass() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
}
