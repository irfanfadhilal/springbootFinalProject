package com.banksultra.finalproject.mappers;

import com.banksultra.finalproject.dto.TripScheduleDto;
import com.banksultra.finalproject.models.TripSchedule;

public class TripScheduleMapper {
    public TripScheduleDto tripScheduleMapDto(TripSchedule tripSchedule){
        TripScheduleDto tripScheduleDto = new TripScheduleDto();
        TripMapper tripMapper = new TripMapper();

        tripScheduleDto.setId(tripSchedule.getId());
        tripScheduleDto.setTripDate(tripSchedule.getTripDate());
        tripScheduleDto.setAvailableSeats(tripSchedule.getAvailableSeats());
        tripScheduleDto.setTripDetail(tripMapper.tripMapDto(tripSchedule.getTripDetail()));

        return tripScheduleDto;
    }
}
