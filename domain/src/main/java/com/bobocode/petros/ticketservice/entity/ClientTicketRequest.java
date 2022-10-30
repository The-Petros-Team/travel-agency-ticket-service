package com.bobocode.petros.ticketservice.entity;

import java.time.LocalDate;

public record ClientTicketRequest(String countryFrom, String countryTo, String cityFrom, String cityTo, LocalDate startDate, LocalDate endDate) {
}
