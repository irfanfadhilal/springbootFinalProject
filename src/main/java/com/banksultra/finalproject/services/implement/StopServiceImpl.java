package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.repositories.StopRepository;
import com.banksultra.finalproject.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StopServiceImpl implements StopService {
    @Autowired
    StopRepository stopRepository;

    @Override
    public Stop createData(Stop stop) { return stopRepository.save(stop); }

    @Override
    public List<Stop> findAll() { return stopRepository.findAll(); }

    @Override
    public Stop findDataById(Long id) {
        return stopRepository.findDataById(id);
    }

    @Override
    public Stop updateData(Long id, Stop stop){
        Stop dataCheck = stopRepository.findDataById(id);
        if(dataCheck != null){
            stop.setId(id);
            if(stop.getCode() == null) stop.setCode(dataCheck.getCode());
            if(stop.getDetail() == null) stop.setDetail(dataCheck.getDetail());
            if(stop.getName() == null) stop.setName(dataCheck.getName());
            return stopRepository.save(stop);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteData(Long id){
        stopRepository.deleteById(id);
        Stop stop = stopRepository.findDataById(id);
        if(stop == null){
            return true;
        }else{
            return false;
        }
    }
}
