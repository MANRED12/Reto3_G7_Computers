package com.team7.computercenter.repository.crudRepository;

import com.team7.computercenter.entities.Category;
import com.team7.computercenter.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
