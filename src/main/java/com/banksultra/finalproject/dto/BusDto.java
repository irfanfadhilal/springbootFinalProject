package com.banksultra.finalproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BusDto {
    private Long id;
    private String code;
    private Integer capacity;
    private String make;
    private AgencyDto agency;
}
