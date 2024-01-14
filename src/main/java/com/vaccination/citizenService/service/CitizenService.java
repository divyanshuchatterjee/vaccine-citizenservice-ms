package com.vaccination.citizenService.service;

import com.vaccination.citizenService.entity.CitizenEntity;
import com.vaccination.citizenService.model.CitizenModel;
import com.vaccination.citizenService.repository.CitizenRepo;
import com.vaccination.citizenService.util.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    CitizenRepo citizenRepo;
    @Autowired
    MapperHelper mapperHelper;
    public CitizenModel getCitizenDetails(Integer id){
        Optional<CitizenEntity> entity = citizenRepo.findById(id);
        if(entity.isPresent()) {
            return mapperHelper.mapEntityToModel(entity.get());
        }else {
            return new CitizenModel();
        }
    }

    public CitizenEntity saveCitizen(CitizenModel citizenModel) {
        return citizenRepo.save(mapperHelper.mapModelToEntity(citizenModel));
    }

    public List<CitizenModel> getCitizenByVacID(Integer vacId) {
        List<CitizenEntity> byVacID = citizenRepo.findByVacID(vacId);
        List<CitizenModel> citizenModels = new ArrayList<>();

        for (CitizenEntity citizenEntity: byVacID ) {
            citizenModels.add(mapperHelper.mapEntityToModel(citizenEntity));
        }

        return  citizenModels;
    }
}
