package com.example.bookMyShowApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class Users extends BaseModel{
    @Column
private String name;

    @Column
private String age;
    @Column
    private String email;

@OneToMany
private List<Ticket> ticketList;

}
