package com.example.bookMyShowApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditoriums extends BaseModel {

    @Column
    private String auditoriumName;

    @Column
    private String capacity;

    @OneToMany(mappedBy = "auditoriums")
    private List<Shows> showsList;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "auditoriums")
    List<Seat> seatList;


}
