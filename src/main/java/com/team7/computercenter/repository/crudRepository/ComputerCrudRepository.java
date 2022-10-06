package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerCrudRepository extends CrudRepository<Computer,Integer> {
}
