package com.banksultra.finalproject.mappers;

import com.banksultra.finalproject.dto.BusDto;
import com.banksultra.finalproject.models.Bus;

public class BusMapper {
    public BusDto busMapDto(Bus bus){
        BusDto busDto = new BusDto();
        AgencyMapper agencyMapper = new AgencyMapper();

        busDto.setId(bus.getId());
        busDto.setCode(bus.getCode());
        busDto.setCapacity(bus.getCapacity());
        busDto.setMake(bus.getMake());
        busDto.setAgency(agencyMapper.agencyMapDto(bus.getAgency()));

        return busDto;
    }
}
