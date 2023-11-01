package com.banksultra.finalproject.services;

import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.models.Trip;

import java.util.List;

public interface TripService {
    Trip createData(Trip trip);
    List<Trip> findAll();
    Trip findDataById(Long id);
    //Trip findDataByTwoStops(Long sourceStop, Long destStop);
    List<TripDto> findDataByTwoStops(Long sourceStop, Long destStop);
    Trip updateData(Long id, Trip trip);
    Boolean deleteData(Long id);
}
