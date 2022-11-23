package com.ust.claims.api.claims;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClaimsService {
    @Autowired
    ClaimsRepository claimsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Claims getClaimsById(Integer id) {
        Claims claimsById=claimsRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return claimsById;
    }

    public ClaimsDto convertToDto(Claims claims) {
        return modelMapper.map(claims, ClaimsDto.class);
    }

    public List<Claims> getAllClaims() {
        return claimsRepository.findAll();
    }

    public List<ClaimsDto> convertToDtoList(List<Claims> claimsList) {
        List<ClaimsDto> claimsDTOList = new ArrayList<>();
        for(Claims claims:claimsList){
            claimsDTOList.add(modelMapper.map(claims,ClaimsDto.class));
        }
        return claimsDTOList;
    }

    public void saveClaims(Claims claims) {
        claims.setCreatedDate(LocalDateTime.now());
        claims.setModifiedDate(claims.getCreatedDate());
        claimsRepository.save(claims);
    }
}
