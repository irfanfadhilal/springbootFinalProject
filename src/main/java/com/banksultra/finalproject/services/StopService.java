package com.banksultra.finalproject.services;

import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Stop;

import java.util.List;

public interface StopService {
    Stop createData(Stop stop);
    List<Stop> findAll();
    Stop findDataById(Long id);
    Stop updateData(Long id, Stop stop);
    Boolean deleteData(Long id);
}
