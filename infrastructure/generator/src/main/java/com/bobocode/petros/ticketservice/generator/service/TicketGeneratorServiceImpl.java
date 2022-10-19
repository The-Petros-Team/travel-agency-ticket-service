package com.bobocode.petros.ticketservice.generator.service;

import com.bobocode.petros.ticketservice.adapter.TicketGeneratorAdapter;
import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.TicketСharacterization;
import com.bobocode.petros.ticketservice.entity.enumeration.FlightClass;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TicketGeneratorServiceImpl implements TicketGeneratorAdapter {

    @Override
    public List<Ticket> generateTicket(TicketСharacterization ticketСharacterization) {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10, 100))
                .limit(6)
                .mapToObj(n -> Ticket.builder()
                        .flightClass(FlightClass.getRandomFlightClass())
                        .countryFrom(ticketСharacterization.countryFrom())
                        .cityFrom(ticketСharacterization.cityFrom())
                        .countryTo(ticketСharacterization.countryTo())
                        .cityTo(ticketСharacterization.cityTo())
                        .flightDate(getRandomFlightDate(ticketСharacterization.startDate(), ticketСharacterization.endDate()))
                        .price(ThreadLocalRandom.current().nextLong(1000))
                        .build()
                )
                .collect(Collectors.toList());
    }

    private LocalDate getRandomFlightDate(LocalDate startDate, LocalDate endDate) {
        if (ThreadLocalRandom.current().nextInt(0, 100) % 2 == 0)
            return startDate;
        return endDate;
    }
}
