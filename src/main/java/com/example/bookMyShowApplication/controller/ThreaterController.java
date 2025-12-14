package com.example.bookMyShowApplication.controller;

import com.example.bookMyShowApplication.dto.AuditoriumDto;
import com.example.bookMyShowApplication.dto.SeatDto;
import com.example.bookMyShowApplication.dto.ShowsDto;
import com.example.bookMyShowApplication.dto.ThreaterDto;
import com.example.bookMyShowApplication.model.City;
import com.example.bookMyShowApplication.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/theater")
@RequiredArgsConstructor
public class ThreaterController {

    private final TheaterService theaterService;

    @PostMapping("/add/{cityName}")
    public void addCity(@PathVariable String cityName) {

        theaterService.addCity(cityName);
    }

    @PostMapping("/add")
    public void addThreater(@RequestBody ThreaterDto threaterDto) {

    theaterService.addTheater(threaterDto);
    }

    @PostMapping("/add/auditorium")
    public String addAuditorium(@RequestBody AuditoriumDto auditoriumDto) {
       return theaterService.addAuditorium(auditoriumDto);
    }

    @PostMapping("/add/seat")
    public String addSeat(@RequestBody List<SeatDto> seatDto) {
        return theaterService.addSeat(seatDto);
    }

    @PostMapping("/add/shows")
    public String addShows(@RequestBody ShowsDto showsDto) {
        return theaterService.addShow(showsDto);
    }

    @GetMapping("/city/{cityId}")
    public City getCity(@PathVariable UUID cityId){
       return theaterService.getCity(cityId);
    }
}
