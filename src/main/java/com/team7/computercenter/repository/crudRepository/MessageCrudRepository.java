package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
