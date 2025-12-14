package com.example.bookMyShowApplication.dto;

import com.example.bookMyShowApplication.model.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BlockSeatDto {
private UUID showId;
private UUID userId;
private List<UUID> seatId;
private SeatType seatType;

}
