package com.banksultra.finalproject.mappers;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.models.Agency;

public class AgencyMapper {
    public AgencyDto agencyMapDto(Agency agency){
        AgencyDto agencyDto = new AgencyDto();
        UserMapper userMapper = new UserMapper();

        agencyDto.setId(agency.getId());
        agencyDto.setCode(agency.getCode());
        agencyDto.setName(agency.getName());
        agencyDto.setDetails(agency.getDetails());
        agencyDto.setOwner(userMapper.userMapDto(agency.getOwner()));
        agencyDto.setAgencyList(agency.getAgencyList());
        agencyDto.setBusList(agency.getBusList());

        return agencyDto;
    }
}
