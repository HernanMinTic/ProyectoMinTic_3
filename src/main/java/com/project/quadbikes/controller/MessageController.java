/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.controller;

import com.project.quadbikes.model.Message;
import com.project.quadbikes.service.MessageService;
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
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageservice;
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/list
    //ej de acceso: http://localhost/cliente-0.0.1.SNAPSHOT/client/444
    
    @GetMapping(value="/list")
    public List<Message> recuperarTodos(){
        return (List<Message>) messageservice.findAll();
    }
    
    @GetMapping(value="/list/(id)")
    public Message recuperarUno(@PathVariable Integer id){
        return messageservice.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Message> agregar(@RequestBody Message message){
        Message mess;
        mess = messageservice.save(message);
        return new ResponseEntity<> (mess,HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Message> actualizar(@RequestBody Message message){
        Message mess = messageservice.findById(message.getId());
        if(mess != null){
            mess.setMessagetext(message.getMessagetext());
            messageservice.save(mess);
        } else{
            return new ResponseEntity<> (mess,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (mess,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    public ResponseEntity<Message> borrar (@PathVariable Integer id){
        Message mess = messageservice.findById(id);
        if(mess != null){
            messageservice.delete(id);
        }else{
            return new ResponseEntity<> (mess,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<> (mess,HttpStatus.OK);
    }
}
