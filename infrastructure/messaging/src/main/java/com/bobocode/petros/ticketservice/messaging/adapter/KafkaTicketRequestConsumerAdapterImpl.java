package com.bobocode.petros.ticketservice.messaging.adapter;

import com.bobocode.petros.ticketservice.adapter.MessageConsumerAdapter;
import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.messaging.dto.TicketRequestDto;
import com.bobocode.petros.ticketservice.usecase.HandleTicketRequestUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KafkaTicketRequestConsumerAdapterImpl implements MessageConsumerAdapter<TicketRequestDto> {

    private final HandleTicketRequestUseCase handleTicketRequestUseCase;

    @KafkaListener(topics = MessageConsumerAdapter.TICKET_REQUEST_TOPIC_NAME)
    public void processMessage(@Payload TicketRequestDto ticketRequest) {
        var bookingId = ticketRequest.getBookingId();
        final var tickets = ticketRequest.getTickets()
                .stream()
                .map(ticketDto -> new ModelMapper().map(ticketDto, Ticket.class))
                .collect(Collectors.toList());
        handleTicketRequestUseCase.handleTicketRequest(bookingId, tickets);
    }

}
