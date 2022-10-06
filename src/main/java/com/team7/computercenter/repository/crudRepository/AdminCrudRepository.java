package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Admin;
import com.team7.computercenter.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
}
