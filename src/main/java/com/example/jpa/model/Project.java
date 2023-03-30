/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USER
 */

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projId;
    private String projName;
    
    
    @JsonIgnore
    @ManyToMany(mappedBy = "assignProjects")
    private Set<Employee> empSet = new HashSet<>();
}
