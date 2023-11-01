package com.banksultra.finalproject.services;

import com.banksultra.finalproject.dto.BusDto;
import com.banksultra.finalproject.models.Bus;
import com.banksultra.finalproject.models.Stop;

import java.util.List;

public interface BusService {
    Bus createData(Bus bus);
    List<BusDto> findAll();
    Bus findDataById(Long id);
    Bus updateData(Long id, Bus bus);
    Boolean deleteData(Long id);
}
