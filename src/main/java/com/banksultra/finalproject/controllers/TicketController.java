package com.banksultra.finalproject.controllers;

import com.banksultra.finalproject.models.Ticket;
import com.banksultra.finalproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createData(@RequestBody Ticket ticket){
        Ticket result = ticketService.createData(ticket);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAll(){
        List<Ticket> result = ticketService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathParam("id") Long id){
        Ticket result = ticketService.findDataById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
