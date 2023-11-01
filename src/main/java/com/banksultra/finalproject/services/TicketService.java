package com.banksultra.finalproject.services;

import com.banksultra.finalproject.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket createData(Ticket ticket);
    List<Ticket> findAll();
    Ticket findDataById(Long id);
}
