package com.example.bookMyShowApplication.dto;


import com.example.bookMyShowApplication.model.Shows;
import com.example.bookMyShowApplication.model.Theater;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AuditoriumDto {

    private String auditoriumName;

    private String capacity;


   private UUID theaterId;
}
