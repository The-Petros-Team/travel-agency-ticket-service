package com.bobocode.petros.ticketservice.entity.enumeration;

import java.util.concurrent.ThreadLocalRandom;

public enum FlightClass {
    FIRST,
    BUSINESS,
    ECONOMY;

    public static FlightClass getRandomFlightClass() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
}
