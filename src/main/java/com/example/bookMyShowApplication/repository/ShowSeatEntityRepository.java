package com.example.bookMyShowApplication.repository;

import com.example.bookMyShowApplication.model.ShowSeat;
import com.example.bookMyShowApplication.model.Ticket;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShowSeatEntityRepository extends JpaRepository<ShowSeat, UUID> {

    @Modifying
    @Query("UPDATE ShowSeat s SET s.ticket = :ticket, s.showSeatStatus = BOOKED WHERE s.id in :ids")
     void updateTickets(@Param("ids") List<UUID> ids, @Param("ticket") Ticket ticket1);

    @Query("Select s FROM ShowSeat s WHERE s.shows.id = :showId AND s.id in :ids")
    List<ShowSeat> findAllByShowsIdAndSeatIdIn(@Param("showId") UUID showId, @Param("ids") List<UUID> ids);
}
