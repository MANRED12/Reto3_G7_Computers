package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Message;
import com.team7.computercenter.entities.Reservation;
import com.team7.computercenter.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @PostMapping("/save")
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }
}