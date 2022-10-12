/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.controller;

import com.project.quadbikes.model.Reservation;
import com.project.quadbikes.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hernan
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/Reservation")
public class ReservationController  {
    @Autowired
    private ReservationService reservationservice;
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/444
    
    @GetMapping(value="/list")
    public List<Reservation> recuperarTodos(){
        return (List<Reservation>) reservationservice.findAll();
    }
    
    @GetMapping(value="/list/(id)")
    public Reservation recuperarUno(@PathVariable Integer id){
        return reservationservice.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Reservation> agregar(@RequestBody Reservation reservation){
        Reservation res;
        res = reservationservice.save(reservation);
        return new ResponseEntity<> (res,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Reservation> actualizar(@RequestBody Reservation reservation){
        Reservation res = reservationservice.findById(reservation.getId());
        if(res != null){
            res.setStartDate(reservation.getStartDate());
            res.setDevolutionDate(reservation.getDevolutionDate());
            res.setStatus(reservation.getStatus());
            res.setClient(reservation.getClient());
            res.setQuadbike(reservation.getQuadbike());
            res.setScore(reservation.getScore());
            reservationservice.save(res);
        } else{
            return new ResponseEntity<> (res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (res,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    public ResponseEntity<Reservation> borrar (@PathVariable Integer id){
        Reservation res = reservationservice.findById(id);
        if(res != null){
            reservationservice.delete(id);
        }else{
            return new ResponseEntity<> (res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (res,HttpStatus.OK);
    }
}