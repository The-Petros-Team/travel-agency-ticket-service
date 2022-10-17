package com.bobocode.petros.ticketservice.adapter;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.TicketСharacterization;

import java.util.List;

public interface TicketGeneratorAdapter {
    List<Ticket> generateTicket(TicketСharacterization ticketСharacterization);
}
