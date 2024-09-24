package com.gfg.spring.boot.app.controller;

import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.response.EmployeeResponse;
import com.gfg.spring.boot.app.service.EmployeeService;
import com.gfg.spring.boot.app.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {

        EmployeeResponse employee = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/employees")
    private ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> employeeResponseList = employeeService.getEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseList);

    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.RemoveEmployeeById(id));
    }

    @PostMapping("/employees")
    private ResponseEntity<Boolean> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createEmployee(employee));
    }



}