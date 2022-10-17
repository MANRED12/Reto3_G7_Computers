package com.team7.computercenter.service;

import com.team7.computercenter.entities.Computer;
import com.team7.computercenter.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll(){
        return computerRepository.getAll();
    }
    public Optional<Computer> getById(int computerId) {
        return computerRepository.getById(computerId);
    }
    public Computer save(Computer p){
        if(p.getId()==null){
            return computerRepository.save(p);
        }
        return p;
    }
    public boolean deleteComputer (int id){
        Optional<Computer> pOp=computerRepository.getById(id);
        if(pOp.isPresent()){
            computerRepository.delete(pOp.get());
            return true;
        }
        return false;
    }

    public Computer update(Computer p){
        if(p.getId()!=null){
            Optional<Computer> e= computerRepository.getById(p.getId());
            if(e.isPresent()){
                Computer k = e.get();
                if(p.getName()!=null){
                    k.setName(p.getName());
                }
                if(p.getBrand()!=null){
                    k.setBrand(p.getBrand());
                }
                if(p.getYear()!=null){
                    k.setYear(p.getYear());
                }
                if(p.getDescription()!=null){
                    k.setDescription(p.getDescription());
                }
                if(p.getCategory()!=null){
                    k.setCategory(p.getCategory());
                }
                return computerRepository.save(k);
            }
    }
        return p;
    }
}

