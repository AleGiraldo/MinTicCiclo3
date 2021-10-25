/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.service;

import com.usa.ciclo3.model.Reservation;
import com.usa.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ale Giraldo
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationAux = reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationAux.isEmpty()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation() == null){
            Optional<Reservation> reservationAux = reservationRepository.getReservation(reservation.getIdReservation());
            if(!reservationAux.isEmpty()){
                if(reservation.getStartDate() != null){
                    reservationAux.get().setStartDate(reservation.getStartDate());
                }
                
                if(reservation.getDevolutionDate() != null){
                    reservationAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                reservationRepository.save(reservationAux.get());
                return reservationAux.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    public Boolean delReservation(Integer id){
        Boolean aBoolean = getReservation(id).map(reservation -> {reservationRepository.delReservation(reservation);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
