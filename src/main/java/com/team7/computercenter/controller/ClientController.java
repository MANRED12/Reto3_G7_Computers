package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Client;
import com.team7.computercenter.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")

public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int clientId) {
        return clientService.getById(clientId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c) {
        return clientService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client c) {
        return clientService.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clientService.deleteClient(id);
    }
}
