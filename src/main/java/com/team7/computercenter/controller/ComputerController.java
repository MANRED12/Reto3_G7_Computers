package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Computer;
import com.team7.computercenter.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/all")
    public List<Computer> getAll(){
        return computerService.getAll();
    }
    @PostMapping("/save")
    public Computer save(@RequestBody Computer p){
        return computerService.save(p);
    }
}
