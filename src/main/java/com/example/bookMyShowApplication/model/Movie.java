package com.example.bookMyShowApplication.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "movie")
public class Movie extends BaseModel {

    @Column
    private String movieName;

    @Column
    private String moviePoster;
    
    @Column
    private String movieDesctiption;

    @OneToMany
    private List<Shows> showsList;


}
