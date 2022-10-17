package com.team7.computercenter.repository;

import com.team7.computercenter.entities.Computer;
import com.team7.computercenter.repository.crudRepository.ComputerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {
    @Autowired
    private ComputerCrudRepository computerCrudRepository;

    public List<Computer> getAll(){
        return (List<Computer>) computerCrudRepository.findAll();
    }
    public Optional<Computer> getById(int id){
        return computerCrudRepository.findById(id);
    }
    public Computer save(Computer p){
        return computerCrudRepository.save(p);
    }
    public void delete(Computer p){
        computerCrudRepository.delete(p);
    }
}