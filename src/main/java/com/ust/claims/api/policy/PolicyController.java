package com.ust.claims.policy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping("/policy/{id}")
    public ResponseEntity<PolicyDto> get(@PathVariable Integer id){
        try{
            Policy policy = policyService.getPolicyById(id);
            return new ResponseEntity<PolicyDto>(policyService.convertToDto(policy), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<PolicyDto>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/policy")
    public ResponseEntity<List<PolicyDto>> getAll() {
        try {
            List<Policy> policy = policyService.getAllPolicy();
            return new ResponseEntity<List<PolicyDto>>(policyService.convertToDtoList(policy), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<PolicyDto>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/policy")
    public ResponseEntity<Policy> add(@RequestBody Policy policy){
        policyService.savePolicy(policy);
        return new ResponseEntity<Policy>(HttpStatus.OK);
    }
}




