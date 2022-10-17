package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Computer;
import com.team7.computercenter.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Computer")
@CrossOrigin(origins = "*")

public class ComputerController {
    @Autowired
    private ComputerService computerService;
    @GetMapping("/all")
    public List<Computer> getAll(){
        return computerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Computer> getById(@PathVariable("id") int computerId) {
        return computerService.getById(computerId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer p) {
        return computerService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer p) {
        return computerService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return computerService.deleteComputer(id);
    }
}
