package com.ust.claims.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AdminController {
    //.
    @Autowired
    AdminService adminService;

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminDto> get(@PathVariable Integer id){
        try{
            Admin admin = adminService.getAdminById(id);
            return new ResponseEntity<AdminDto>(adminService.convertToDto(admin), HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<AdminDto>> getAll() {
        try {
            List<Admin> adminList = adminService.getAllAdmins();
            return new ResponseEntity<List<AdminDto>>(adminService.convertToDtoList(adminList), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<AdminDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> add(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return new ResponseEntity<Admin>(HttpStatus.OK);
    }

}
