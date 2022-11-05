package com.bobocode.petros.ticketservice.messaging.adapter;

import com.bobocode.petros.ticketservice.adapter.MessageProducerAdapter;
import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;
import com.bobocode.petros.ticketservice.messaging.dto.TicketStatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class KafkaProducerAdapterImpl implements MessageProducerAdapter {
    private final KafkaTemplate<String, TicketStatusResponseDto> kafkaTemplate;

    @Override
    public void sendTicketResponse(UUID bookingId, BookingStatusEnum bookingStatus) {
        final var ticketStatusResponseDto = new TicketStatusResponseDto(bookingId, bookingStatus);
        kafkaTemplate.send(TICKET_RESPONSE_TOPIC_NAME, ticketStatusResponseDto);
    }
}
