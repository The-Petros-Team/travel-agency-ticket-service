package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.adapter.TicketGeneratorAdapter;
import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.TicketСharacterization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTicketsUseCaseImpl implements GetTicketsUseCase {
    private final TicketGeneratorAdapter generatorService;

    @Override
    public List<Ticket> generate(TicketСharacterization ticketСharacterization) {
        return generatorService.generateTicket(ticketСharacterization);
    }
}
