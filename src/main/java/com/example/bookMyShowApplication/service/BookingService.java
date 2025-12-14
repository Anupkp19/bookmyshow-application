package com.example.bookMyShowApplication.service;

import com.example.bookMyShowApplication.dto.BlockSeatDto;
import com.example.bookMyShowApplication.dto.UsersDto;
import com.example.bookMyShowApplication.model.Ticket;

import java.util.Optional;

public interface BookingService {
    String addUsers(UsersDto usersDto);

    Boolean blockSeat(BlockSeatDto blockSeatDto);

    Optional<Ticket> bookTicket(BlockSeatDto blockSeatDto);
}
