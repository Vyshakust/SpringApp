package com.ust.claims.api.treatment;

import com.ust.claims.api.specialist.Specialist;
import com.ust.claims.api.specialist.SpecialistDto;
import com.ust.claims.api.specialist.SpecialistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Treatment getTreatmentById(Integer id) {
        Treatment treatmentById=treatmentRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return treatmentById;
    }

    public TreatmentDto convertToDto(Treatment treatmentList) {
        return modelMapper.map(treatmentList, TreatmentDto.class);
    }

    public void saveTreatment(Treatment treatment) {
        treatment.setCreatedDate(LocalDateTime.now());
        treatment.setModifiedDate(treatment.getCreatedDate());
        treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public List<TreatmentDto> convertToDtoList(List<Treatment> treatmentList) {
        List<TreatmentDto> treatmentDtoList = new ArrayList<>();
        for (Treatment treatment : treatmentList) {
            treatmentDtoList.add(modelMapper.map(treatment, TreatmentDto.class));
        }
        return treatmentDtoList;
    }
}