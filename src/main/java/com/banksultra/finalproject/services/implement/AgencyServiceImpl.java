package com.banksultra.finalproject.services.implement;

import com.banksultra.finalproject.dto.AgencyDto;
import com.banksultra.finalproject.dto.UserDto;
import com.banksultra.finalproject.mappers.AgencyMapper;
import com.banksultra.finalproject.mappers.UserMapper;
import com.banksultra.finalproject.models.Agency;
import com.banksultra.finalproject.models.Bus;
import com.banksultra.finalproject.models.User;
import com.banksultra.finalproject.repositories.AgencyRepository;
import com.banksultra.finalproject.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    AgencyRepository agencyRepository;

    @Override
    public Agency createData(Agency agency){
        return agencyRepository.save(agency);
    }

    @Override
    public List<AgencyDto> findAll() {
        List<Agency> agencyList = agencyRepository.findAll();
        AgencyMapper agencyMapper = new AgencyMapper();
        return agencyList.stream()
                .map(agencyMapper::agencyMapDto)
                .collect(Collectors.toList());
    }

    @Override
    public Agency findDataById(Long id) {
        return agencyRepository.findDataById(id);
    }

    @Override
    public Agency updateData(Long id, Agency agency){
        Agency dataCheck = agencyRepository.findDataById(id);
        if(dataCheck != null){
            agency.setId(id);
            if(agency.getCode() == null) agency.setCode(dataCheck.getCode());
            if(agency.getDetails() == null) agency.setDetails(dataCheck.getDetails());
            if(agency.getName() == null) agency.setName(dataCheck.getName());
            if(agency.getOwner() == null) agency.setOwner(dataCheck.getOwner());
            return agencyRepository.save(agency);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteData(Long id){
        agencyRepository.deleteById(id);
        Agency agency = agencyRepository.findDataById(id);
        if(agency == null){
            return true;
        }else{
            return false;
        }
    }
}
