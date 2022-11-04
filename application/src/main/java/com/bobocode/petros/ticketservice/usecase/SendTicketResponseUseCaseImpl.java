package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.adapter.MessageProducerAdapter;
import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SendTicketResponseUseCaseImpl implements SendTicketResponseUseCase {
    private final MessageProducerAdapter messageProducerAdapter;

    @Override
    public void sendTicketStatus(UUID bookingId, BookingStatusEnum bookingStatus) {
        messageProducerAdapter.sendTicketResponse(bookingId, bookingStatus);
    }
}
