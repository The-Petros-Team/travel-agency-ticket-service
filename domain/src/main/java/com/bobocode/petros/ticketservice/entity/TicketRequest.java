package com.bobocode.petros.ticketservice.entity;

import java.time.LocalDate;

public record TicketRequest(String countryFrom, String countryTo, String cityFrom, String cityTo, LocalDate startDate, LocalDate endDate) {
}
