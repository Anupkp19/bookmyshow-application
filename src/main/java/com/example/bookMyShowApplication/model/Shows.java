package com.example.bookMyShowApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Shows  extends BaseModel{
    @ManyToOne
    private Movie movie;
    private String showStartTime;
    private String showEndTime;
    @ManyToOne
    private Auditoriums auditoriums;
    @OneToMany(mappedBy = "shows")
    private List<ShowSeat> seatList;


}
