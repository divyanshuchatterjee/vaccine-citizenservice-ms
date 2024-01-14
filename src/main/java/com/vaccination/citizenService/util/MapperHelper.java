package com.vaccination.citizenService.util;

import com.vaccination.citizenService.entity.CitizenEntity;
import com.vaccination.citizenService.model.CitizenModel;
import org.springframework.stereotype.Component;

@Component
public class MapperHelper {
    /**
     * This method maps model class to the entity class
     * @param citizenModel model received in the request
     * @return mapped entity
     */
    public CitizenEntity mapModelToEntity(CitizenModel citizenModel){
        CitizenEntity citizenEntity = new CitizenEntity();
        citizenEntity.setId(citizenModel.getId_no());
        citizenEntity.setName(citizenModel.getName());
        citizenEntity.setVaccinationCenterID(citizenModel.getVaccinationCenterID());
        return citizenEntity;
    }

    /**
     * This method maps entity class to the model class
     * @param citizenEntity entity received after running the query
     * @return mapped model
     */
    public CitizenModel mapEntityToModel(CitizenEntity citizenEntity){
        CitizenModel citizenModel = new CitizenModel();
        citizenModel.setId_no(citizenEntity.getId());
        citizenModel.setName(citizenEntity.getName());
        citizenModel.setVaccinationCenterID(citizenEntity.getVaccinationCenterID());
        return citizenModel;
    }
}
