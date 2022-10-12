/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.quadbikes.service;

import com.project.quadbikes.model.Category;
import java.util.List;

/**
 *
 * @author hernan
 */
public interface CategoryService {
    public Category save(Category category);
    public void delete(Integer id);
    public Category findById(Integer id);
    public List<Category> findAll();
}
