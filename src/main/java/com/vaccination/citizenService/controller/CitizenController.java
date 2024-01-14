package com.vaccination.citizenService.controller;

import com.vaccination.citizenService.entity.CitizenEntity;
import com.vaccination.citizenService.model.CitizenModel;
import com.vaccination.citizenService.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/get/{id}")
    public ResponseEntity<CitizenModel> getByID(@PathVariable("id") Integer id){
        CitizenModel details = citizenService.getCitizenDetails(id);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PostMapping("/postById")
    public ResponseEntity<CitizenEntity> postByID(@RequestBody CitizenModel citizenModel){
        CitizenEntity citizenEntity = citizenService.saveCitizen(citizenModel);
        return new ResponseEntity<>(citizenEntity, HttpStatus.OK);
    }

    @GetMapping("/getByVaccinationCenterId/{vacID}")
    public ResponseEntity<List<CitizenModel>> getByVaccinationCenterId(@PathVariable("vacID") Integer vacId){
        List<CitizenModel> citizenByVacID = citizenService.getCitizenByVacID(vacId);
        return new ResponseEntity<>(citizenByVacID, HttpStatus.OK);
    }
}
