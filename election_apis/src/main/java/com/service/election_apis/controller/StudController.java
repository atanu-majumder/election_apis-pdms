package com.service.election_apis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.entity.TestJ;
import com.service.election_apis.service.StudService;

@RestController
@RequestMapping("/pdms/v1/students")
public class StudController {

	
	private final StudService service;

    public StudController(StudService service) {
        this.service = service;
    }

//    @PostMapping("/save")
//    public TestJ save(@RequestBody TestJ student) {
//        return service.saveStud(student);
//    }
//
//    @GetMapping("/{id}")
//    public TestJ getById(@PathVariable Integer id) {
//        return service.getStudById(id);
//    }
}
