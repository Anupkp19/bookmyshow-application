package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityEntityRepository extends JpaRepository<City, UUID> {
}
