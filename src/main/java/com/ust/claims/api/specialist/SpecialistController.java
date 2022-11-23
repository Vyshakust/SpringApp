package com.ust.claims.api.specialist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class SpecialistController {

    @Autowired
    SpecialistService specialistService;

    @GetMapping("/specialist/{id}")
    public ResponseEntity<SpecialistDto> get(@PathVariable Integer id){
        try{
            Specialist specialist = specialistService.getSpecialistById(id);
            return new ResponseEntity<SpecialistDto>(specialistService.convertToDto(specialist), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<SpecialistDto>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/specialists")
    public ResponseEntity<List<SpecialistDto>> getAll() {
        try {
            List<Specialist> specialist = specialistService.getAllSpecialist();
            return new ResponseEntity<List<SpecialistDto>>(specialistService.convertToDtoList(specialist), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<SpecialistDto>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/specialist")
    public ResponseEntity<Specialist> add(@RequestBody Specialist specialist){
        specialistService.saveSpecialist(specialist);
        return new ResponseEntity<Specialist>(HttpStatus.OK);
    }
}


