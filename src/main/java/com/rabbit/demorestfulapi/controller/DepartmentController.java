package com.rabbit.demorestfulapi.controller;


import com.rabbit.demorestfulapi.dto.DepartmentResponseDTO;
import com.rabbit.demorestfulapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(values = "/departments")
public class DepartmentController {
    @Autowired
    DepartmentRepository repository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
    public List<DepartmentResponseDTO> getDepartmentsList(){
        return repository.findAll().stream().map(DepartmentResponseDTO::new).toList();
    }
}