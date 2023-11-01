package com.banksultra.finalproject.services;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.models.Agency;

import java.util.List;

public interface AgencyService {
    Agency createData(Agency agency);
    List<AgencyDto> findAll();
    Agency findDataById(Long id);
    Agency updateData(Long id, Agency agency);
    Boolean deleteData(Long id);
}
