/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.quadbikes.service;

import com.project.quadbikes.model.Quadbike;
import java.util.List;

/**
 *
 * @author hernan
 */
public interface QuadbikeService {
    public Quadbike save(Quadbike quadbike);
    public void delete(Integer id);
    public Quadbike findById(Integer id);
    public List<Quadbike> findAll();
}
