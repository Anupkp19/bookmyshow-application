package com.example.bookMyShowApplication.controller;

import com.example.bookMyShowApplication.dto.BlockSeatDto;
import com.example.bookMyShowApplication.dto.MoviesDto;
import com.example.bookMyShowApplication.dto.UsersDto;
import com.example.bookMyShowApplication.model.Ticket;
import com.example.bookMyShowApplication.service.BookingService;
import com.example.bookMyShowApplication.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;
    private final BookingService bookingService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MoviesDto moviesDto) {
       return movieService.addMovie(moviesDto);

    }

    @PostMapping("/add/user")
    public String addUser(@RequestBody UsersDto usersDto) {
        return bookingService.addUsers(usersDto);

    }

    @PostMapping("/block/seat")
    public Boolean blockSeat(@RequestBody BlockSeatDto blockSeatDto) {
        return bookingService.blockSeat(blockSeatDto);

    }


    @PostMapping("/book/seat")
    public Ticket bookSeat(@RequestBody BlockSeatDto blockSeatDto) {
        return bookingService.bookTicket(blockSeatDto).orElse(null);

    }







}
