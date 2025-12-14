package com.example.bookMyShowApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{

    @Column
    private String theaterName;

    @Column
    private String theaterAddress;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theater")
    private List<Auditoriums> auditorimsList;


}
