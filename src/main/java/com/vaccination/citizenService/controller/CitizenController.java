package com.vaccination.citizenService.controller;

import com.vaccination.citizenService.entity.CitizenEntity;
import com.vaccination.citizenService.exceptionHandler.EmptyQueryParamException;
import com.vaccination.citizenService.model.CitizenModel;
import com.vaccination.citizenService.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    //    We ca use Map as query param too to handle custom exception
//    @GetMapping(value = {"/get/{citizenId}","/get/"})
//   public ResponseEntity<CitizenModel> getByID(@PathVariable Map<String, String> queryParam){
//        System.out.println(queryParam);
//        if(queryParam.get("id")==null){
//            throw new EmptyQueryParamException("Null ID");
//        }
//        CitizenModel details = citizenService.getCitizenDetails(Integer.valueOf(queryParam.get("id")));
//       Optional.ofNullable(id).isPresent())
//           throw new EmptyQueryParamException("msg");
//
//       CitizenModel details = citizenService.getCitizenDetails(Integer.valueOf(id));
//        return new ResponseEntity<>(details, HttpStatus.OK);
//    }


    @GetMapping(value = {"/get/{citizenId}","/get/"})
    public ResponseEntity<CitizenModel> getByID(@PathVariable("citizenId") Optional<Integer> citizenId){
        if(citizenId.isEmpty()){
            throw new EmptyQueryParamException("Null ID");
        }
        CitizenModel details = citizenService.getCitizenDetails(citizenId.get());
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PostMapping("/postById")
    public ResponseEntity<CitizenEntity> postByID(@RequestBody CitizenModel citizenModel){
        if(0 == citizenModel.getId_no() || citizenModel.getName() == null){
            throw new EmptyQueryParamException("The 'id' query param is missing");
        }
        CitizenEntity citizenEntity = citizenService.saveCitizen(citizenModel);
        return new ResponseEntity<>(citizenEntity, HttpStatus.OK);
    }

    @GetMapping("/getByVaccinationCenterId/{vacID}")
    public ResponseEntity<List<CitizenModel>> getByVaccinationCenterId(@PathVariable("vacID") Integer vacId){
        List<CitizenModel> citizenByVacID = citizenService.getCitizenByVacID(vacId);
        return new ResponseEntity<>(citizenByVacID, HttpStatus.OK);
    }
}
