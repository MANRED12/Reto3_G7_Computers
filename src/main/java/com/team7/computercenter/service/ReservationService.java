package com.team7.computercenter.service;


import com.team7.computercenter.entities.Reservation;
import com.team7.computercenter.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            r.setStatus("created");
            return reservationRepository.save(r);
        }else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else{
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(r.getIdReservation());
            if(q.isPresent()){
                if(r.getComputer()!=null){
                    q.get().setComputer(r.getComputer());
                }
                if(r.getClient()!=null){
                    q.get().setClient(r.getClient());
                }
                if(r.getStartDate()!=null){
                    q.get().setStartDate(r.getStartDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int idReservation){
        boolean flag = false;
        Optional<Reservation>p= reservationRepository.getReservation(idReservation);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

