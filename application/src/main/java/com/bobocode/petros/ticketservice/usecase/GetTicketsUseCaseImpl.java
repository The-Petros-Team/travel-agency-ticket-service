package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.adapter.TicketGeneratorAdapter;
import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTicketsUseCaseImpl implements GetTicketsUseCase {
    private final TicketGeneratorAdapter generatorService;

    @Override
    public List<Ticket> generate(TicketRequest ticketRequest) {
        return generatorService.generateTicket(ticketRequest);
    }
}
