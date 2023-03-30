/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author USER
 */

@Entity
@Table(name = "employee")
@Data
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empName;
    
    
    @ManyToMany
    @JoinTable(name ="emp_proj",
            joinColumns = @JoinColumn(name = "empId"),
            inverseJoinColumns = @JoinColumn(name = "projId")
    )
    private Set<Project> assignProjects = new HashSet<>();
}
