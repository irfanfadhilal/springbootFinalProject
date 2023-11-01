package com.banksultra.finalproject.services;

import com.banksultra.finalproject.dto.TripScheduleDto;
import com.banksultra.finalproject.models.TripSchedule;

import java.sql.Date;
import java.util.List;

public interface TripScheduleService {
    TripSchedule createData(TripSchedule tripSchedule);
    List<TripScheduleDto> findAll();
    TripSchedule findDataById(Long id);
    List<TripSchedule> findDataByTripDate(Date tripDate);
    TripSchedule updateData(Long id, TripSchedule tripSchedule);
    Boolean deleteData(Long id);
}
