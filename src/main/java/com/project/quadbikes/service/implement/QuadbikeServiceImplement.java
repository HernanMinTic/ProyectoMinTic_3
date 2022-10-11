/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.service.implement;

import com.project.quadbikes.model.Quadbike;
import com.project.quadbikes.repository.QuadbikeRepository;
import com.project.quadbikes.service.QuadbikeService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hernan
 */
@Service
public class QuadbikeServiceImplement implements QuadbikeService {

    @Autowired
    private QuadbikeRepository quadbikerepository;
    
    @Override
    @Transactional
    public Quadbike save(Quadbike quadbike){
        return quadbikerepository.save(quadbike);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        quadbikerepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Quadbike findById(Integer id){
        return quadbikerepository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Quadbike> findAll(){
        return (List<Quadbike>) quadbikerepository.findAll();
    }
}
