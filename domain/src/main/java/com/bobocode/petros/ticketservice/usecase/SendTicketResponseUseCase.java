package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;

import java.util.UUID;

public interface SendTicketResponseUseCase {
    void sendTicketStatus(UUID bookingId, BookingStatusEnum bookingStatus);
}
