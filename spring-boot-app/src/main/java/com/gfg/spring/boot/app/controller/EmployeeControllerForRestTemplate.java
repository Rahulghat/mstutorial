package com.gfg.spring.boot.app.controller;

import com.gfg.spring.boot.app.response.EmployeeResponse;
import com.gfg.spring.boot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * This class is using webflux to get response from Address miscroservices
 */

@RestController
public class EmployeeControllerForRestTemplate {


    @Autowired
    @Qualifier("RestExample")
    private EmployeeService employeeService;
    
    @GetMapping("/employeesRest/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetailsUsingWebF(@PathVariable("id") int id) {

        EmployeeResponse employee = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }



}
