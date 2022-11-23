package com.ust.claims.api.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Admin getAdminById(Integer id) {
        Admin adminById=adminRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
        return adminById;
    }

    public AdminDto convertToDto(Admin admin) {
        return modelMapper.map(admin, AdminDto.class);
    }
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public List<AdminDto> convertToDtoList(List<Admin> adminList) {
        List<AdminDto> adminDTOList = new ArrayList<>();
        for(Admin admin:adminList){
            adminDTOList.add(modelMapper.map(admin,AdminDto.class));
        }
        return adminDTOList;
    }

    public void saveAdmin(Admin admin) {
        admin.setCreatedDate(LocalDateTime.now());
        admin.setModifiedDate(admin.getCreatedDate());
        adminRepository.save(admin);
    }

}
