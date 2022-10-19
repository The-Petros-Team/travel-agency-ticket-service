package com.bobocode.petros.ticketservice.entity;

import com.bobocode.petros.ticketservice.entity.enumeration.FlightClass;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Ticket {
    private FlightClass flightClass;
    private String countryFrom;
    private String cityFrom;
    private String countryTo;
    private String cityTo;
    private LocalDate flightDate;
    private Long price;
}
