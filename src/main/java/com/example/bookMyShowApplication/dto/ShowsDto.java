package com.example.bookMyShowApplication.dto;

import com.example.bookMyShowApplication.model.Auditoriums;
import com.example.bookMyShowApplication.model.Movie;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ShowsDto {
    private UUID movieId;
    private String showStartTime;
    private String showEndTime;
    private UUID auditoriumId;


}
