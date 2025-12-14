package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheaterEntityRepository extends JpaRepository<Theater, UUID> {
}
