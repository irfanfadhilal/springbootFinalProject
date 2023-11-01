package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.dto.BusDto;
import com.banksultra.finalproject.dto.UserDto;
import com.banksultra.finalproject.mappers.BusMapper;
import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Bus;
import com.banksultra.finalproject.models.Stop;
import com.banksultra.finalproject.models.User;
import com.banksultra.finalproject.repositories.BusRepository;
import com.banksultra.finalproject.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepository;

    @Override
    public Bus createData(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<BusDto> findAll() {
        List<Bus> busList = busRepository.findAll();
        BusMapper busMapper = new BusMapper();
        return busList.stream()
                .map(busMapper::busMapDto)
                .collect(Collectors.toList());
    }

    @Override
    public Bus findDataById(Long id) {
        return busRepository.findDataById(id);
    }

    @Override
    public Bus updateData(Long id, Bus bus){
        Bus dataCheck = busRepository.findDataById(id);
        if(dataCheck != null){
            bus.setId(id);
            if(bus.getCode() == null) bus.setCode(dataCheck.getCode());
            if(bus.getCapacity() == null) bus.setCapacity(dataCheck.getCapacity());
            if(bus.getMake() == null) bus.setMake(dataCheck.getMake());
            if(bus.getAgency() == null) bus.setAgency(dataCheck.getAgency());
            return busRepository.save(bus);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteData(Long id){
        busRepository.deleteById(id);
        Bus bus = busRepository.findDataById(id);
        if(bus == null){
            return true;
        }else{
            return false;
        }
    }
}
