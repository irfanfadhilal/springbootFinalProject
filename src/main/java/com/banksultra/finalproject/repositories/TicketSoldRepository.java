package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.Ticket;
import com.banksultra.finalproject.models.TicketSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface TicketSoldRepository extends JpaRepository<TicketSold, Long> {
    String findDataByTripDate =
            "SELECT a.* FROM ticket_sold a " +
            "LEFT JOIN trip_schedule b ON a.id = b.id" +
            "WHERE b.trip_date = :tripDate";
    @Query(value = findDataByTripDate, nativeQuery = true)
    public List<TicketSold> findDataByTripDate(Date tripDate);
}
