package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
