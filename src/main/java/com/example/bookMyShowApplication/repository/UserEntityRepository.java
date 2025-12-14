package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<Users, UUID> {
}
