package com.team7.computercenter.repository;

import com.team7.computercenter.entities.Admin;
import com.team7.computercenter.entities.Category;
import com.team7.computercenter.repository.crudRepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int idAdmin){
        return adminCrudRepository.findById(idAdmin);
    }

    public Admin save(Admin a){
        return adminCrudRepository.save(a);
    }

    public void delete(Admin a){
        adminCrudRepository.delete(a);
    }
}
