/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo3.web;

import com.usa.ciclo3.model.Reservation;
import com.usa.ciclo3.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ale Giraldo
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    
    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable Integer id){
        return reservationService.getReservation(id);
    }
    
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
}
