package com.banksultra.finalproject.dto;

import com.banksultra.finalproject.models.Stop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TripDto {
    private Long id;
    private Integer fare;
    private Date journeyTime;
    private Stop sourceStop;
    private Stop destStop;
    private BusDto bus;
}
