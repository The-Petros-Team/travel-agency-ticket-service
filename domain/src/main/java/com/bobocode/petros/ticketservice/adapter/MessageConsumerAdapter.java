package com.bobocode.petros.ticketservice.adapter;

public interface MessageConsumerAdapter<T> {
    String TICKET_REQUEST_TOPIC_NAME = "ticket-requests";

    void processMessage(T messagePayload);

}
