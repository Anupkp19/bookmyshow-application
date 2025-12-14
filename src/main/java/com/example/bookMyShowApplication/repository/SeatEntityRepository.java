package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatEntityRepository extends JpaRepository<Seat, UUID> {
}
