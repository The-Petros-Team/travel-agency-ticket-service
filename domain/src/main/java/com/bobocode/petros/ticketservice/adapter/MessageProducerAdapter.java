package com.bobocode.petros.ticketservice.adapter;

import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;

import java.util.UUID;

public interface MessageProducerAdapter {
    String TICKET_RESPONSE_TOPIC_NAME = "ticket-responses";

    void sendTicketResponse(UUID bookingId, BookingStatusEnum bookingStatus);
}
