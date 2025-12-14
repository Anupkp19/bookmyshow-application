package com.example.bookMyShowApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket  extends BaseModel{

    @Column
    private int amount;

    @ManyToOne
    private Shows shows;

    @OneToMany(mappedBy = "ticket")
    List<ShowSeat> seatList;

    @ManyToOne
    private Users users;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;





}
