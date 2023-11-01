package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    String findDataById = "SELECT * FROM trip WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public Trip findDataById(Long id);

    String findDataByTwoStops = "SELECT * FROM trip WHERE source_stop=:sourceStop AND dest_stop=:destStop";
    @Query(value = findDataByTwoStops, nativeQuery = true)
    public List<Trip> findDataByTwoStops(Long sourceStop, Long destStop);
}
