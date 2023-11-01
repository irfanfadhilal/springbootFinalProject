package com.banksultra.finalproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TicketSold implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticketId;

    @ManyToOne
    @JoinColumn(name = "tripSchedule")
    private TripSchedule tripSchedule;
}
