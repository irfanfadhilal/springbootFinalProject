package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.models.Ticket;
import com.banksultra.finalproject.repositories.TicketRepository;
import com.banksultra.finalproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket createData(Ticket ticket) { return ticketRepository.save(ticket); }

    @Override
    public List<Ticket> findAll() { return ticketRepository.findAll(); }

    @Override
    public Ticket findDataById(Long id) { return ticketRepository.findDataById(id); }
}
