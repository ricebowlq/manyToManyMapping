/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.controller;

import com.example.jpa.model.Project;
import com.example.jpa.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author USER
 */

@RestController
@RequestMapping("/proj")
public class ProjectController {
    
    @Autowired
    private ProjectRepository projRepo;
    
    @PostMapping("/save")
    public ResponseEntity<Project> saveProj(@RequestBody Project emp){
        
        projRepo.save(emp);
        
//        return ResponseEntity.ok("Data Saved");
          return new ResponseEntity<>(HttpStatus.CREATED);  
    }
    
    
    
    @GetMapping("/get")
    public List<Project> getProj(){
        
        return projRepo.findAll();
    }
    
}
