package com.banksultra.finalproject.controllers;

import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.models.Trip;
import com.banksultra.finalproject.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/trip")
public class TripController {
    @Autowired
    TripService tripService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createData(@RequestBody Trip trip){
        Trip result = tripService.createData(trip);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAll(){
        List<Trip> result = tripService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathParam("id") Long id){
        Trip result = tripService.findDataById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findDataByTwoStops", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findDataByTwoStops(@PathParam("sourceStop") Long sourceStop, @PathParam("destStop") Long destStop){
        List<TripDto> result = tripService.findDataByTwoStops(sourceStop, destStop);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PutMapping(value = "/updateData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateData(@PathParam("id") Long id, @RequestBody Trip trip){
        Trip result = tripService.updateData(id, trip);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @DeleteMapping(value = "/deleteData", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteData(@PathParam("id") int id){
        Boolean result = tripService.deleteData((long) id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
