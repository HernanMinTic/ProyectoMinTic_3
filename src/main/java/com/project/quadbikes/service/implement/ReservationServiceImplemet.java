/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.service.implement;

import com.project.quadbikes.model.Reservation;
import com.project.quadbikes.repository.ReservationRepository;
import com.project.quadbikes.service.ReservationService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hernan
 */
@Service
public class ReservationServiceImplemet implements ReservationService {

    @Autowired
    private ReservationRepository reservationrepository;
    
    @Override
    @Transactional
    public Reservation save(Reservation reservation){
        return reservationrepository.save(reservation);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        reservationrepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Reservation findById(Integer id){
        return reservationrepository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Reservation> findAll(){
        return (List<Reservation>) reservationrepository.findAll();
    }
}
