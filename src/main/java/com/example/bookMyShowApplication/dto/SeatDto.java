package com.example.bookMyShowApplication.dto;

import com.example.bookMyShowApplication.model.Auditoriums;
import com.example.bookMyShowApplication.model.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SeatDto {

    private int seatNumber;

    private int rowValue;

    private int colValue;


    private SeatType seatType;

    private UUID auditoriumId;

}
