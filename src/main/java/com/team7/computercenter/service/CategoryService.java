package com.team7.computercenter.service;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else {
            Optional<Category> ctg = categoryRepository.getCategory(c.getId());
            if(!ctg.isPresent()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(c.getId());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    q.get().setDescription(c.getDescription());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int id){
        Boolean del = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return del;
    }
}

