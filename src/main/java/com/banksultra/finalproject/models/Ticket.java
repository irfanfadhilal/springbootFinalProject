package com.banksultra.finalproject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer seatNumber;

    private Boolean cancelable;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date journeyDate;

    @ManyToOne
    @JoinColumn(name = "passenger")
    private User passenger;

    @ManyToOne
    @JoinColumn(name = "tripSchedule")
    private TripSchedule tripSchedule;
}
