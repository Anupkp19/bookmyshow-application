package com.example.bookMyShowApplication.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel {
    @Column
    private int seatNumber;

    @Column
    private int rowValue;

    @Column
    private int colValue;


    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    private Auditoriums auditoriums;




}
