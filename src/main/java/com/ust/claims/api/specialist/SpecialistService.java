package com.ust.claims.api.specialist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SpecialistService {

        @Autowired
        SpecialistRepository specialistRepository;
        @Autowired
        private ModelMapper modelMapper;
        public Specialist getSpecialistById(Integer id) {
            Specialist specialistById=specialistRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
            return specialistById;
        }

        public SpecialistDto convertToDto(Specialist specialist) {
            return modelMapper.map(specialist, SpecialistDto.class);
        }

        public void saveSpecialist(Specialist specialist) {
            specialist.setCreatedDate(LocalDateTime.now());
            specialist.setModifiedDate(specialist.getCreatedDate());
            specialistRepository.save(specialist);
        }

        public List<Specialist> getAllSpecialist() {
            return specialistRepository.findAll();
        }

        public List<SpecialistDto> convertToDtoList(List<Specialist> specialistList) {
            List<SpecialistDto> specialistDtoList = new ArrayList<>();
            for(Specialist specialist:specialistList){
                specialistDtoList.add(modelMapper.map(specialist,SpecialistDto.class));
            }
            return specialistDtoList;
        }
}
