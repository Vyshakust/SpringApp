package com.ust.claims.api.hospital;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Hospital getHospitalById(Integer id) {
        Hospital hospitalById=hospitalRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return hospitalById;
    }

    public HospitalDto convertToDto(Hospital hospital) {
        return modelMapper.map(hospital, HospitalDto.class);
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public List<HospitalDto> convertToDtoList(List<Hospital> hospitalList) {
        List<HospitalDto> hospitalDTOList = new ArrayList<>();
        for(Hospital hospital:hospitalList){
            hospitalDTOList.add(modelMapper.map(hospital,HospitalDto.class));
        }
        return hospitalDTOList;
    }

    public void saveHospital(Hospital hospital) {
        hospital.setCreatedDate(LocalDateTime.now());
        hospital.setModifiedDate(hospital.getCreatedDate());
        hospitalRepository.save(hospital);
    }
}