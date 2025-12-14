package com.example.bookMyShowApplication.service;

import com.example.bookMyShowApplication.dto.AuditoriumDto;
import com.example.bookMyShowApplication.dto.SeatDto;
import com.example.bookMyShowApplication.dto.ShowsDto;
import com.example.bookMyShowApplication.dto.ThreaterDto;
import com.example.bookMyShowApplication.model.City;

import java.util.List;
import java.util.UUID;

public interface TheaterService {
    public void addTheater(ThreaterDto threaterDto);

    public void addCity(String cityName);

    public City getCity(UUID cityId);


   public String addAuditorium(AuditoriumDto auditoriumDto);

    String addShow(ShowsDto showsDto);

    String addSeat(List<SeatDto> seatDto);
}
