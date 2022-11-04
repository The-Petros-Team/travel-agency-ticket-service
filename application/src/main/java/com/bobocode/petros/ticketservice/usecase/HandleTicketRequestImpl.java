package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.enumeration.BookingStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class HandleTicketRequestImpl implements HandleTicketRequestUseCase {

    private final SendTicketResponseUseCaseImpl sendTicketResponseUseCase;

    @Override
    public void handleTicketRequest(UUID bookingId, List<Ticket> tickets) {
        sendTicketResponseUseCase.sendTicketStatus(bookingId, BookingStatusEnum.ACCEPTED);
        randomDelayFrom10To30Seconds();
        sendTicketResponseUseCase.sendTicketStatus(bookingId, BookingStatusEnum.IN_PROGRESS);
        randomDelayFrom10To30Seconds();
        sendTicketResponseUseCase.sendTicketStatus(bookingId, BookingStatusEnum.BOOKED);
    }

    @SneakyThrows
    private void randomDelayFrom10To30Seconds() {
        final var seconds = ThreadLocalRandom.current().nextLong(10, 30);
        Thread.sleep(seconds * 1000);
    }
}
