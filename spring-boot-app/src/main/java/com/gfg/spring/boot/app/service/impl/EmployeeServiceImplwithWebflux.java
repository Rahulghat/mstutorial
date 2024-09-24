package com.gfg.spring.boot.app.service.impl;

import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.mapper.EmployeeMapper;
import com.gfg.spring.boot.app.repositories.EmployeeRepo;
import com.gfg.spring.boot.app.response.AddressResponse;
import com.gfg.spring.boot.app.response.EmployeeResponse;
import com.gfg.spring.boot.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

@Service("webflux")
@AllArgsConstructor
public class EmployeeServiceImplwithWebflux implements EmployeeService {


    private final EmployeeRepo employeeRepo;

    private final EmployeeMapper employeeMapper;


    @Autowired
    private WebClient webClient;

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = employeeMapper.EmployeetoEmployeeResponse(employee.orElse(null));

        // Using WebClient
        AddressResponse addressResponse = webClient.get().uri("/address/" + id).retrieve().bodyToMono(AddressResponse.class).block();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployees() {
        return List.of();
    }

    @Override
    public Boolean RemoveEmployeeById(Integer id) {
        return null;
    }

    @Override
    public Boolean createEmployee(Employee employee) {
        return null;
    }
}
