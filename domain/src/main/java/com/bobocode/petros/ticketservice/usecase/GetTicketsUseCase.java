package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.ClientTicketRequest;

import java.util.List;

public interface GetTicketsUseCase {
    List<Ticket> generate(ClientTicketRequest clientTicketRequest);
}
