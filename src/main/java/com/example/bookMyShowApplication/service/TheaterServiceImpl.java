package com.example.bookMyShowApplication.service;

import com.example.bookMyShowApplication.dto.AuditoriumDto;
import com.example.bookMyShowApplication.dto.SeatDto;
import com.example.bookMyShowApplication.dto.ShowsDto;
import com.example.bookMyShowApplication.dto.ThreaterDto;
import com.example.bookMyShowApplication.model.*;
import com.example.bookMyShowApplication.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService{


    private final CityEntityRepository cityEntityRepository;
    private final TheaterEntityRepository theaterEntityRepository;

    private final AuditoriumEntityRepository auditoriumEntityRepository;
    private final ShowEntityRepository showEntityRepository;
    private final MovieEntityRepository movieEntityRepository;

    private final SeatEntityRepository seatEntityRepository;



    @Override
    public void addTheater(ThreaterDto threaterDto) {
        Optional<City> city = cityEntityRepository.findById(threaterDto.getCityId());

        Theater theater =  new Theater();
        theater.setTheaterAddress(threaterDto.getTheaterAddress());
        theater.setTheaterName(threaterDto.getTheaterName());
        theater.setCity(city.orElse(null));

        theaterEntityRepository.save(theater);


    }

    @Override
    public void addCity(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        cityEntityRepository.save(city);




    }

    @Override
    public City getCity(UUID cityId) {
        City city  = cityEntityRepository.findById(cityId).orElse(null);
        System.out.println(city);
        return city;
    }

    @Override
    public String addAuditorium(AuditoriumDto auditoriumDto) {
        Theater theater = theaterEntityRepository.findById(auditoriumDto.getTheaterId()).orElse(null);

        Auditoriums auditoriums = new Auditoriums();
        auditoriums.setAuditoriumName(auditoriumDto.getAuditoriumName());
        auditoriums.setCapacity(auditoriumDto.getCapacity());
        auditoriums.setTheater(theater);
        auditoriumEntityRepository.save(auditoriums);

        return "Auditorium added in the theater list successfully";
    }

    @Override
    public String addShow(ShowsDto showsDto) {
        // can add exceptions for auditorium or movie if they are null
        Auditoriums auditoriums = auditoriumEntityRepository
                .findById(showsDto
                        .getAuditoriumId())
                .orElse(null);
        Movie movie = movieEntityRepository
                .findById(showsDto
                        .getMovieId())
                .orElse(null);

        Shows shows = new Shows();

        shows.setAuditoriums(auditoriums);
        shows.setMovie(movie);
        shows.setShowStartTime(showsDto.getShowStartTime());
        shows.setShowEndTime(showsDto.getShowEndTime());

        showEntityRepository.save(shows);


        return "added the shows";
    }

    @Override
    public String addSeat(List<SeatDto> seatDto) {

        seatDto.forEach(this::addSeatss);


        return "Added seat successfully";
    }
    private void addSeatss(SeatDto seatDto){
        Auditoriums auditoriums = auditoriumEntityRepository
                .findById(seatDto.getAuditoriumId())
                .orElse(null);

        Seat seat = new Seat();
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setSeatType(seatDto.getSeatType());
        seat.setRowValue(seatDto.getRowValue());
        seat.setColValue(seatDto.getColValue());
        seat.setAuditoriums(auditoriums);
        seatEntityRepository.save(seat);
    }

}
