package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.entities.Client;
import com.team7.computercenter.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @PostMapping("/save")
    public Client save(@RequestBody Client c){

        return clientService.save(c);
    }
}