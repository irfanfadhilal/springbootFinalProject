package com.banksultra.finalproject.repositories;

import com.banksultra.finalproject.models.TripSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TripScheduleRepository extends JpaRepository<TripSchedule, Long> {
    String findDataById = "SELECT * FROM trip_schedule WHERE id = :id";
    @Query(value = findDataById, nativeQuery = true)
    public TripSchedule findDataById(Long id);

    String findDataByTripDate = "SELECT * FROM trip_schedule WHERE trip_date = :tripDate";
    @Query(value = findDataByTripDate, nativeQuery = true)
    public List<TripSchedule> findDataByTripDate(Date tripDate);
}
