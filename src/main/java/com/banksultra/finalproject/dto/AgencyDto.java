package com.banksultra.finalproject.dto;

import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Bus;
import com.banksultra.finalproject.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class AgencyDto {
    private Long id;
    private String code;
    private String name;
    private String details;
    private UserDto owner;
    private List<Bus> busList;
    private List<Agency> agencyList;
}
