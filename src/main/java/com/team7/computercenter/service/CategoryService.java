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

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
    public Optional<Category> getById(int categoryId) {
        return categoryRepository.getById(categoryId);
    }
    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        }
        return c;
    }
    public boolean deleteCategory (int id){
        Optional<Category> cOp =categoryRepository.getById(id);
        if(cOp.isPresent()){
            categoryRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>g= categoryRepository.getById(c.getId());
            if(g.isPresent()){
                Category k = g.get();
                if(c.getDescription()!=null){
                    k.setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    k.setName(c.getName());
                }
                return categoryRepository.save(k);
            }
        }
        return c;
    }
}

