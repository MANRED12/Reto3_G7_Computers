package com.team7.computercenter.service;

import com.team7.computercenter.entities.Score;
import com.team7.computercenter.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int idScore){
        return scoreRepository.getScore(idScore);
    }
    public Score save(Score s){
        if(s.getIdScore() == null){
            return scoreRepository.save(s);
        }else {
            Optional<Score> e = scoreRepository.getScore(s.getIdScore());
            if(e.isPresent()){
                return s;
            }else{
                return scoreRepository.save(s);
            }
        }
    }
    public Score update(Score s){
        if(s.getIdScore()!=null){
            Optional<Score> q = scoreRepository.getScore(s.getIdScore());
            if(q.isPresent()){
                if(s.getScore()!=null){
                    q.get().setScore(s.getScore());
                }
                if(s.getMessage()!=null){
                    q.get().setMessage(s.getMessage());
                }
                if(s.getReservation()!=null){
                    q.get().setReservation(s.getReservation());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return s;
            }
        }else{
            return s;
        }
    }
    public boolean delete(int idScore){
        boolean flag = false;
        Optional<Score>p= scoreRepository.getScore(idScore);
        if(p.isPresent()){
            scoreRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

