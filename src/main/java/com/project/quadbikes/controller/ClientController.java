/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.controller;

import com.project.quadbikes.model.Client;
import com.project.quadbikes.service.ClientService;
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
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientservice;
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/444
    
    @GetMapping(value="/list")
    public List<Client> recuperarTodos(){
        return (List<Client>) clientservice.findAll();
    }
    
    @GetMapping(value="/list/(id)")
    public Client recuperarUno(@PathVariable Integer id){
        return clientservice.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Client> agregar(@RequestBody Client client){
        Client cli;
        cli = clientservice.save(client);
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Client> actualizar(@RequestBody Client client){
        Client cli = clientservice.findById(client.getId());
        if(cli != null){
            cli.setName(client.getName());
            cli.setEmail(client.getEmail());
            cli.setAge(client.getAge());
            clientservice.save(cli);
        } else{
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    public ResponseEntity<Client> borrar (@PathVariable Integer id){
        Client cli = clientservice.findById(id);
        if(cli != null){
            clientservice.delete(id);
        }else{
            return new ResponseEntity<> (cli,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (cli,HttpStatus.OK);
    }
}