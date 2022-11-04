package com.bobocode.petros.ticketservice.messaging.dto;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
public final class TicketRequestDto {
    private UUID bookingId;
    private List<TicketDto> tickets;
}
