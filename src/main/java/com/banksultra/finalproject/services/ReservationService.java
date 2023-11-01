package com.banksultra.finalproject.services;

import com.banksultra.finalproject.models.Ticket;

public interface ReservationService {
    Boolean bookTicket(Long ticketId, Ticket ticket);
}
