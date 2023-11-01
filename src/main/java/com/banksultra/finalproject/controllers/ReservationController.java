package com.banksultra.finalproject.controllers;

import com.banksultra.finalproject.dto.TripDto;
import com.banksultra.finalproject.dto.TripScheduleDto;
import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.models.Ticket;
import com.banksultra.finalproject.models.Trip;
import com.banksultra.finalproject.models.TripSchedule;
import com.banksultra.finalproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
    @Autowired
    StopService stopService;

    @Autowired
    TripService tripService;

    @Autowired
    TripScheduleService tripScheduleService;

    @Autowired
    TicketService ticketService;

    @Autowired
    ReservationService reservationService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/stops", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> stops(){
        List<Stop> result = stopService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/tripsByStops", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> tripsByStops(@PathParam("sourceStop") Long sourceStop, @PathParam("destStop") Long destStop){
        List<TripDto> result = tripService.findDataByTwoStops(sourceStop, destStop);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/tripSchedules", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> tripSchedules(){
        List<TripScheduleDto> result = tripScheduleService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PostMapping(value = "/bookTicket", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> bookTicket(@PathParam("ticketId") Long id, @RequestBody Ticket ticket){
        Boolean result = reservationService.bookTicket(id, ticket);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
