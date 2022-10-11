/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.service.implement;

import com.project.quadbikes.model.Client;
import com.project.quadbikes.repository.ClientRepository;
import com.project.quadbikes.service.ClientService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hernan
 */
@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClientRepository clientrepository;
    
    //Se implementa el guardado en la tabla del cliente
    @Override
    @Transactional
    public Client save(Client client){
        return clientrepository.save(client);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        clientrepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Client findById(Integer id){
        return clientrepository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Client> findAll(){
        return (List<Client>) clientrepository.findAll();
    }
}
