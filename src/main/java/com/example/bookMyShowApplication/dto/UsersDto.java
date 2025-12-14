package com.example.bookMyShowApplication.dto;

import com.example.bookMyShowApplication.model.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersDto {
    private String name;

    private String age;

    private String email;

    private List<Ticket> ticketList;

}
