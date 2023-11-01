package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.mappers.AgencyMapper;
import com.banksultra.finalproject.mappers.TripMapper;
import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Trip;
import com.banksultra.finalproject.repositories.TripRepository;
import com.banksultra.finalproject.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;

    @Override
    public Trip createData(Trip trip) { return tripRepository.save(trip); }

    @Override
    public List<Trip> findAll() { return tripRepository.findAll(); }

    @Override
    public Trip findDataById(Long id) {
        return tripRepository.findDataById(id);
    }

    @Override
    public List<TripDto> findDataByTwoStops(Long sourceStop, Long destStop){
        List<Trip> tripList = tripRepository.findDataByTwoStops(sourceStop, destStop);
        TripMapper tripMapper = new TripMapper();
        return tripList.stream()
                .map(tripMapper::tripMapDto)
                .collect(Collectors.toList());
    }

    @Override
    public Trip updateData(Long id, Trip trip){
        Trip dataCheck = tripRepository.findDataById(id);
        if(dataCheck != null){
            trip.setId(id);
            if(trip.getFare() == null) trip.setFare(dataCheck.getFare());
            if(trip.getJourneyTime() == null) trip.setJourneyTime(dataCheck.getJourneyTime());
            if(trip.getSourceStop() == null) trip.setSourceStop(dataCheck.getSourceStop());
            if(trip.getDestStop() == null) trip.setDestStop(dataCheck.getDestStop());
            if(trip.getBus() == null) trip.setBus(dataCheck.getBus());
            if(trip.getAgency() == null) trip.setAgency(dataCheck.getAgency());
            return tripRepository.save(trip);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteData(Long id){
        tripRepository.deleteById(id);
        Trip trip = tripRepository.findDataById(id);
        if(trip == null){
            return true;
        }else{
            return false;
        }
    }
}
