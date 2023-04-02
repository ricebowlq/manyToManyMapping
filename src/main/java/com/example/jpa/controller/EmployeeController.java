/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.controller;

import com.example.jpa.model.Employee;
import com.example.jpa.model.Project;
import com.example.jpa.repository.EmployeeRepository;
import com.example.jpa.repository.ProjectRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author USER
 */

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository empRepo;
    
    @Autowired
    private ProjectRepository projRepo;
    
    
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
        
        empRepo.save(emp);
        
//        return ResponseEntity.ok("Data Saved");
          return new ResponseEntity<>(HttpStatus.CREATED);  
    }
    
    
    
    @GetMapping("/get")
    public List<Employee> getEmp(){
        
        return empRepo.findAll();
    }
    
    
    @DeleteMapping("delete/{empId}")
    public ResponseEntity removeEmp(@PathVariable Long empId){
        
        empRepo.deleteById(empId);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    
    
    @PutMapping("/{empId}/project/{projId}")
    public Employee assignProjectToEmployee(
            @PathVariable Long empId,
            @PathVariable Long projId){
        //return employeeService.assignProjectToEmployee(empId, projectId);
        
        ///////   SETTING ONE EMP TO MULTIPLE PROJ AND ONE PROJ TO MULTIPLE EMPS 
        
        Set<Project> projectSet = null;
        Employee employee = empRepo.findById(empId).get();
        Project project = projRepo.findById(projId).get();
        projectSet =  employee.getAssignProjects();
        projectSet.add(project);
        employee.setAssignProjects(projectSet);
        return empRepo.save(employee);
    }
    
}
  