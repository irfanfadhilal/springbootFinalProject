package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.dto.TripScheduleDto;
import com.banksultra.finalproject.mappers.AgencyMapper;
import com.banksultra.finalproject.mappers.TripScheduleMapper;
import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Trip;
import com.banksultra.finalproject.models.TripSchedule;
import com.banksultra.finalproject.repositories.TripRepository;
import com.banksultra.finalproject.repositories.TripScheduleRepository;
import com.banksultra.finalproject.services.TripScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TripScheduleServiceImpl implements TripScheduleService {
    @Autowired
    TripScheduleRepository tripScheduleRepository;

    @Override
    public TripSchedule createData(TripSchedule tripSchedule) { return tripScheduleRepository.save(tripSchedule); }

    @Override
    public List<TripScheduleDto> findAll() {
        List<TripSchedule> tripScheduleList = tripScheduleRepository.findAll();
        TripScheduleMapper tripScheduleMapper = new TripScheduleMapper();
        return tripScheduleList.stream()
                .map(tripScheduleMapper::tripScheduleMapDto)
                .collect(Collectors.toList());
    }

    @Override
    public TripSchedule findDataById(Long id) {
        return tripScheduleRepository.findDataById(id);
    }

    @Override
    public List<TripSchedule> findDataByTripDate(Date tripDate){
        return tripScheduleRepository.findDataByTripDate(tripDate);
    }

    @Override
    public TripSchedule updateData(Long id, TripSchedule tripSchedule){
        TripSchedule dataCheck = tripScheduleRepository.findDataById(id);
        System.out.println("------------- TRIP SCHEDULE ID : "+id);
        if(dataCheck != null){
            tripSchedule.setId(id);
            if(tripSchedule.getTripDate() == null) tripSchedule.setTripDate(dataCheck.getTripDate());
            if(tripSchedule.getAvailableSeats() == null) tripSchedule.setAvailableSeats(dataCheck.getAvailableSeats());
            if(tripSchedule.getTripDetail() == null) tripSchedule.setTripDetail(dataCheck.getTripDetail());
            return tripScheduleRepository.save(tripSchedule);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteData(Long id){
        tripScheduleRepository.deleteById(id);
        TripSchedule tripSchedule = tripScheduleRepository.findDataById(id);
        if(tripSchedule == null){
            return true;
        }else{
            return false;
        }
    }
}
