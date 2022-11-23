package com.ust.claims.api.treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/treatment/{id}")
    public ResponseEntity<TreatmentDto> get(@PathVariable Integer id){
        try{
            Treatment treatment = treatmentService.getTreatmentById(id);
            return new ResponseEntity<TreatmentDto>(treatmentService.convertToDto(treatment), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<TreatmentDto>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/treatments")
    public ResponseEntity<List<TreatmentDto>> getAll() {
        try {
            List<Treatment> treatmentList = treatmentService.getAllTreatments();
            return new ResponseEntity<List<TreatmentDto>>(treatmentService.convertToDtoList(treatmentList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<TreatmentDto>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/treatment")
    public ResponseEntity<Treatment> add(@RequestBody Treatment treatment){
        treatmentService.saveTreatment(treatment);
        return new ResponseEntity<Treatment>(HttpStatus.OK);
    }
}