package com.ust.claims.api.patient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Patient getPatientById(Integer id) {
        Patient patientById=patientRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return patientById;
    }

    public PatientDto convertToDto(Patient patient) {
        return modelMapper.map(patient, PatientDto.class);
    }

    public void savePatient(Patient patient) {
        patient.setCreatedDate(LocalDateTime.now());
        patient.setModifiedDate(patient.getCreatedDate());
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<PatientDto> convertToDtoList(List<Patient> patientList) {
        List<PatientDto> patientDTOList = new ArrayList<>();
        for(Patient patient:patientList){
            patientDTOList.add(modelMapper.map(patient,PatientDto.class));
        }
        return patientDTOList;
    }
}