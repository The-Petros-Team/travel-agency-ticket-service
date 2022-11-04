package com.bobocode.petros.ticketservice.messaging.dto;

import com.bobocode.petros.ticketservice.entity.enumeration.FlightClassEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketDto {
    private FlightClassEnum flightClass;
    private String countryFrom;
    private String cityFrom;
    private String countryTo;
    private String cityTo;
    private LocalDate flightDate;
    private Long price;
}
