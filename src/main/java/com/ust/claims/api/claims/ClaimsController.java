package com.ust.claims.api.claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClaimsController {

    @Autowired
    ClaimsService claimsService;

    @GetMapping("/claims/{id}")
    public ResponseEntity<ClaimsDto> get(@PathVariable Integer id){
        try{
            Claims claims = claimsService.getClaimsById(id);
            return new ResponseEntity<ClaimsDto>(claimsService.convertToDto(claims), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<ClaimsDto>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/claims")
    public ResponseEntity<List<ClaimsDto>> getAll() {
        try {
            List<Claims> claimsList = claimsService.getAllClaims();
            return new ResponseEntity<List<ClaimsDto>>(claimsService.convertToDtoList(claimsList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<ClaimsDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/claims")
    public ResponseEntity<Claims> add(@RequestBody Claims claims){
        claimsService.saveClaims(claims);
        return new ResponseEntity<Claims>(HttpStatus.OK);
    }
}
