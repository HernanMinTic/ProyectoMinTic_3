/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.controller;

import com.project.quadbikes.model.Category;
import com.project.quadbikes.model.Client;
import com.project.quadbikes.service.CategoryService;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryservice;
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/444
    
    @GetMapping(value="/list")
    public List<Category> recuperarTodos(){
        return (List<Category>) categoryservice.findAll();
    }
    
    @GetMapping(value="/list/(id)")
    public Category recuperarUno(@PathVariable Integer id){
        return categoryservice.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Category> agregar(@RequestBody Category category){
        Category cat;
        cat = categoryservice.save(category);
        return new ResponseEntity<> (cat,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Category> actualizar(@RequestBody Category category){
        Category cat = categoryservice.findById(category.getId());
        if(cat != null){
            cat.setName(category.getName());
            cat.setDescription(category.getDescription());
            categoryservice.save(cat);
        } else{
            return new ResponseEntity<> (cat,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cat,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    public ResponseEntity<Category> borrar (@PathVariable Integer id){
        Category cat = categoryservice.findById(id);
        if(cat != null){
            categoryservice.delete(id);
        }else{
            return new ResponseEntity<> (cat,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cat,HttpStatus.OK);
    }
}
