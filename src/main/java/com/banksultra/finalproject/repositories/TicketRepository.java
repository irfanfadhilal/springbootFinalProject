package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    String findDataById = "SELECT * FROM ticket WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public Ticket findDataById(Long id);
}
