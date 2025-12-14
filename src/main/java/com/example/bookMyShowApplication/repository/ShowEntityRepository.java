package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowEntityRepository extends JpaRepository<Shows, UUID> {
}
