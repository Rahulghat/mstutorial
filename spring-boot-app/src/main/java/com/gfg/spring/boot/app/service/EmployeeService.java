package com.gfg.spring.boot.app.service;

import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public EmployeeResponse getEmployeeById(Integer id);
    public List<EmployeeResponse> getEmployees();
    public Boolean RemoveEmployeeById(Integer id);
    public Boolean createEmployee(Employee employee);
}
