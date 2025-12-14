package com.example.bookMyShowApplication.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MoviesDto {

    private String movieName;
    private String moviePoster;
    private String movieDescription;
}
;