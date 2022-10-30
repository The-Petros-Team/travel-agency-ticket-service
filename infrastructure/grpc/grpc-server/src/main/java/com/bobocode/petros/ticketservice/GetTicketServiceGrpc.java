package com.bobocode.petros.ticketservice;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.ClientTicketRequest;
import com.bobocode.petros.ticketservice.proto.MultipleTicketResponse;
import com.bobocode.petros.ticketservice.proto.TicketRequest;
import com.bobocode.petros.ticketservice.proto.TicketResponse;
import com.bobocode.petros.ticketservice.proto.TicketServiceGrpc;
import com.bobocode.petros.ticketservice.usecase.GetTicketsUseCase;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@GrpcService
@Service
@RequiredArgsConstructor
public class GetTicketServiceGrpc extends TicketServiceGrpc.TicketServiceImplBase {
    private final GetTicketsUseCase useCase;

    @Override
    public void getTickets(TicketRequest request, StreamObserver<MultipleTicketResponse> responseObserver) {
        var response = MultipleTicketResponse.newBuilder()
                .addAllTickets(useCase.generate(toCharacterization(request))
                        .stream()
                        .map(this::toTicketResponse)
                        .collect(Collectors.toList()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private TicketResponse toTicketResponse(Ticket ticket) {
        return TicketResponse.newBuilder()
                .setClass_(ticket.getFlightClass().name())
                .setCountryFrom(ticket.getCountryFrom())
                .setCityFrom(ticket.getCityFrom())
                .setCountryTo(ticket.getCountryTo())
                .setCityTo(ticket.getCityTo())
                .setFlightDate(Timestamp.newBuilder()
                        .setSeconds(ticket.getFlightDate().toEpochDay())
                        .build())
                .setPrice(ticket.getPrice())
                .build();
    }

    private ClientTicketRequest toCharacterization(TicketRequest request) {
        return new ClientTicketRequest(request.getCountryFrom(), request.getCountryTo(),
                request.getCityFrom(), request.getCityTo(),
                LocalDateTime.ofEpochSecond(request.getStartDate().getSeconds(), request.getStartDate().getNanos(), ZoneOffset.UTC).toLocalDate(),
                LocalDateTime.ofEpochSecond(request.getEndDate().getSeconds(), request.getEndDate().getNanos(), ZoneOffset.UTC).toLocalDate());
    }
}
