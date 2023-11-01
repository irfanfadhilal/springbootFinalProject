package com.banksultra.finalproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TripScheduleDto {
    private Long id;
    private Date tripDate;
    private Integer availableSeats;
    private TripDto tripDetail;
}
