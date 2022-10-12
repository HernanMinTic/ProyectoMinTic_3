/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.quadbikes.repository;

import com.project.quadbikes.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hernan
 */
public interface ReservationRepository extends CrudRepository<Reservation,Integer>{
    
}