/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.service.implement;

import com.project.quadbikes.model.Message;
import com.project.quadbikes.repository.MessageRepository;
import com.project.quadbikes.service.MessageService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hernan
 */
@Service
public class MessageServiceImplement implements MessageService {

    @Autowired
    private MessageRepository messagerepository;
    
    @Override
    @Transactional
    public Message save(Message message){
        return messagerepository.save(message);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        messagerepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Message findById(Integer id){
        return messagerepository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Message> findAll(){
        return (List<Message>) messagerepository.findAll();
    }
}