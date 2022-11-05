package com.bobocode.petros.ticketservice.messaging.dto;

import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class TicketStatusResponseDto {
    private UUID bookingId;
    private BookingStatusEnum status;
}
