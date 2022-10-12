/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.quadbikes.service;

import com.project.quadbikes.model.Reservation;
import java.util.List;

/**
 *
 * @author hernan
 */
public interface ReservationService {
    public Reservation save(Reservation reservation);
    public void delete(Integer id);
    public Reservation findById(Integer id);
    public List<Reservation> findAll();
}
