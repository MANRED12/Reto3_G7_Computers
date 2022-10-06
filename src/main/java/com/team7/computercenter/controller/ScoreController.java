package com.team7.computercenter.controller;

import com.team7.computercenter.entities.Score;
import com.team7.computercenter.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    @PostMapping("/save")
    public Score save(@RequestBody Score s){
        return scoreService.save(s);
    }
}
