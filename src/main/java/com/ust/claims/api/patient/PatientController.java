package com.ust.claims.api.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> get(@PathVariable Integer id){
        try{
            Patient patient = patientService.getPatientById(id);
            return new ResponseEntity<PatientDto>(patientService.convertToDto(patient), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<PatientDto>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getAll() {
        try {
            List<Patient> patientList = patientService.getAllPatients();
            return new ResponseEntity<List<PatientDto>>(patientService.convertToDtoList(patientList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<PatientDto>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/patient")
    public ResponseEntity<Patient> add(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return new ResponseEntity<Patient>(HttpStatus.OK);
    }
}
