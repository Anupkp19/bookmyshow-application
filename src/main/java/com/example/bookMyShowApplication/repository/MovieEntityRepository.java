package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieEntityRepository extends JpaRepository<Movie, UUID> {

}
