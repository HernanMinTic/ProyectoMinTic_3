/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.controller;

import com.project.quadbikes.model.Quadbike;
import com.project.quadbikes.service.QuadbikeService;
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
@RequestMapping("/quadbike")
public class QuadbikeController {
    @Autowired
    private QuadbikeService quadbikeservice;
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/444
    
    @GetMapping(value="/list")
    public List<Quadbike> recuperarTodos(){
        return (List<Quadbike>) quadbikeservice.findAll();
    }
    
    @GetMapping(value="/list/(id)")
    public Quadbike recuperarUno(@PathVariable Integer id){
        return quadbikeservice.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Quadbike> agregar(@RequestBody Quadbike quadbike){
        Quadbike quad;
        quad = quadbikeservice.save(quadbike);
        return new ResponseEntity<> (quad,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Quadbike> actualizar(@RequestBody Quadbike quadbike){
        Quadbike quad = quadbikeservice.findById(quadbike.getId());
        if(quad != null){
            quad.setBrand(quadbike.getBrand());
            quad.setModel(quadbike.getModel());
            quad.setCategory_id(quadbike.getCategory_id());
            quad.setName(quadbike.getName());
            quadbikeservice.save(quad);
        } else{
            return new ResponseEntity<> (quad,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (quad,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    public ResponseEntity<Quadbike> borrar (@PathVariable Integer id){
        Quadbike quad = quadbikeservice.findById(id);
        if(quad != null){
            quadbikeservice.delete(id);
        }else{
            return new ResponseEntity<> (quad,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (quad,HttpStatus.OK);
    }
}
