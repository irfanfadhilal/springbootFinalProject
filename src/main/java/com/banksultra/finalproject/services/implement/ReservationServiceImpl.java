package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.models.Ticket;
import com.banksultra.finalproject.models.TicketSold;
import com.banksultra.finalproject.repositories.TicketRepository;
import com.banksultra.finalproject.repositories.TicketSoldRepository;
import com.banksultra.finalproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketSoldRepository ticketSoldRepository;

    @Override
    public Boolean bookTicket(Long ticketId, Ticket ticket){
        Ticket dataCheck = ticketRepository.findDataById(ticketId);
        if(dataCheck != null){
            // Update passenger_id di table ticket
            ticket.setId(ticketId);
            ticket.setJourneyDate(dataCheck.getJourneyDate());
            ticket.setSeatNumber(dataCheck.getSeatNumber());
            ticket.setCancelable(dataCheck.getCancelable());
            ticket.setTripSchedule(dataCheck.getTripSchedule());
            if(ticket.getPassenger() == null) ticket.setPassenger(dataCheck.getPassenger());
            ticketRepository.save(ticket);

            // Insert ke table ticket_sold
            Ticket ticketIdSold = new Ticket();
            ticketIdSold.setId(ticketId);

            TicketSold ticketSold = new TicketSold();
            ticketSold.setTicketId(ticketIdSold);
            ticketSold.setTripSchedule(dataCheck.getTripSchedule());
            ticketSoldRepository.save(ticketSold);

            return true;
        }else{
            return null;
        }
    }
}
