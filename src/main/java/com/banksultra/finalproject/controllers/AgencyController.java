package com.banksultra.finalproject.controllers;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/agency")
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createData(@RequestBody Agency agency){
        Agency result = agencyService.createData(agency);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findAll(){
        List<AgencyDto> result = agencyService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/findById", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathParam("id") Long id){
        Agency result = agencyService.findDataById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PutMapping(value = "/updateData", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateData(@PathParam("id") Long id, @RequestBody Agency agency){
        Agency result = agencyService.updateData(id, agency);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @DeleteMapping(value = "/deleteData", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteData(@PathParam("id") int id){
        Boolean result = agencyService.deleteData((long) id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
