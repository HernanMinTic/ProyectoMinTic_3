/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.quadbikes.service.implement;

import com.project.quadbikes.model.Category;
import com.project.quadbikes.repository.CategoryRepository;
import com.project.quadbikes.service.CategoryService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hernan
 */
@Service
public class CategoryServiceImplemet implements CategoryService {

    @Autowired
    private CategoryRepository categoryrepository;
    
    @Override
    @Transactional
    public Category save(Category category){
        return categoryrepository.save(category);
    }
    
    @Override
    @Transactional
    public void delete(Integer id){
        categoryrepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Category findById(Integer id){
        return categoryrepository.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Category> findAll(){
        return (List<Category>) categoryrepository.findAll();
    }
}
