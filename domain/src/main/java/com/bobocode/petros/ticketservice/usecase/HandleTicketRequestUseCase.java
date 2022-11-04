package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;

import java.util.List;
import java.util.UUID;

public interface HandleTicketRequestUseCase {
    void handleTicketRequest(UUID bookingId, List<Ticket> tickets);
}
