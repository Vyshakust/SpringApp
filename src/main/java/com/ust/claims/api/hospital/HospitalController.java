package com.ust.claims.api.hospital;

import com.ust.claims.api.patient.Patient;
import com.ust.claims.api.patient.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hospital/{id}")
    public ResponseEntity<HospitalDto> get(@PathVariable Integer id){
        try{
            Hospital hospital = hospitalService.getHospitalById(id);
            return new ResponseEntity<HospitalDto>(hospitalService.convertToDto(hospital), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<HospitalDto>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hospital")
    public ResponseEntity<List<HospitalDto>> getAll() {
        try {
            List<Hospital> hospitalList = hospitalService.getAllHospitals();
            return new ResponseEntity<List<HospitalDto>>(hospitalService.convertToDtoList(hospitalList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<HospitalDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/hospital")
    public ResponseEntity<Hospital> add(@RequestBody Hospital hospital){
        hospitalService.saveHospital(hospital);
        return new ResponseEntity<Hospital>(HttpStatus.OK);
    }
}
