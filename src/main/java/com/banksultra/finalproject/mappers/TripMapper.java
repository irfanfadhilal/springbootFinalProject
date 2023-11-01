package com.banksultra.finalproject.mappers;

import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.models.Trip;

public class TripMapper {
    public TripDto tripMapDto(Trip trip){
        TripDto tripDto = new TripDto();
        BusMapper busMapper = new BusMapper();

        tripDto.setId(trip.getId());
        tripDto.setFare(trip.getFare());
        tripDto.setJourneyTime(trip.getJourneyTime());
        tripDto.setSourceStop(trip.getSourceStop());
        tripDto.setDestStop(trip.getDestStop());
        tripDto.setBus(busMapper.busMapDto(trip.getBus()));

        return tripDto;
    }
}
