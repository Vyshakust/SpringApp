package com.ust.claims.api.policy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Policy getPolicyById(Integer id) {
        Policy policyById=policyRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return policyById;
    }

    public PolicyDto convertToDto(Policy policy) {
        return modelMapper.map(policy, PolicyDto.class);
    }

    public void savePolicy(Policy policy) {
        policy.setCreatedDate(LocalDateTime.now());
        policy.setModifiedDate(policy.getCreatedDate());
        policyRepository.save(policy);
    }

    public List<Policy> getAllPolicy() {
        return policyRepository.findAll();
    }

    public List<PolicyDto> convertToDtoList(List<Policy> policyList) {
        List<PolicyDto> policyDtoList = new ArrayList<>();
        for(Policy policy:policyList){
            policyDtoList.add(modelMapper.map(policy,PolicyDto.class));
        }
        return policyDtoList;
    }
}

