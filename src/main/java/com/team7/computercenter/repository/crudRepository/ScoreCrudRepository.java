package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
