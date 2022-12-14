package com.bobocode.petros.ticketservice.entity;

import com.bobocode.petros.ticketservice.entity.enumeration.FlightClassEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private FlightClassEnum flightClass;
    private String countryFrom;
    private String cityFrom;
    private String countryTo;
    private String cityTo;
    private LocalDate flightDate;
    private Long price;
}
