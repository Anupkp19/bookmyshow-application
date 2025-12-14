package com.example.bookMyShowApplication.dto;


import com.example.bookMyShowApplication.model.City;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ThreaterDto {


    private String theaterName;

   private String theaterAddress;


    private UUID cityId;
}
