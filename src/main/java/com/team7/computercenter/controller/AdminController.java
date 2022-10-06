package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Admin;
import com.team7.computercenter.entities.Category;
import com.team7.computercenter.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @PostMapping("/save")
    public Admin save(@RequestBody Admin a){

        return adminService.save(a);
    }
}
