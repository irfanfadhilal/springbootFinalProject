package com.banksultra.finalproject.controllers;

import com.banksultra.finalproject.dto.TripScheduleDto;
import com.banksultra.finalproject.models.TripSchedule;
import com.banksultra.finalproject.services.TripScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/tripSchedule")
public class TripScheduleController {
    @Autowired
    TripScheduleService tripScheduleService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createData(@RequestBody TripSchedule tripSchedule){
        TripSchedule result = tripScheduleService.createData(tripSchedule);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAll(){
        List<TripScheduleDto> result = tripScheduleService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathParam("id") Long id){
        TripSchedule result = tripScheduleService.findDataById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findDataByTripDate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findDataByTripDate(@PathParam("tripDate") Date tripDate){
        List<TripSchedule> result = tripScheduleService.findDataByTripDate(tripDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PutMapping(value = "/updateData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateData(@PathParam("id") Long id, @RequestBody TripSchedule tripSchedule){
        System.out.println("------------- TRIP SCHEDULE ID : "+tripSchedule.getTripDate());
        TripSchedule result = tripScheduleService.updateData(id, tripSchedule);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @DeleteMapping(value = "/deleteData", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteData(@PathParam("id") int id){
        Boolean result = tripScheduleService.deleteData((long) id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
