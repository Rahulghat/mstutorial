package com.gfg.spring.boot.app.service.impl;

import com.gfg.spring.boot.app.client.AddressClient;
import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.mapper.EmployeeMapper;
import com.gfg.spring.boot.app.repositories.EmployeeRepo;
import com.gfg.spring.boot.app.response.AddressResponse;
import com.gfg.spring.boot.app.response.EmployeeResponse;
import com.gfg.spring.boot.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final EmployeeMapper employeeMapper;

    @Autowired
    private AddressClient addressClient;

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {

        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = employeeMapper.EmployeetoEmployeeResponse(employee.orElse(null));
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeResponse> listofempresponse = employees.stream().map(emp ->
        {
            return employeeMapper.EmployeetoEmployeeResponse(emp);
        }).collect(Collectors.toList());
        return listofempresponse;
    }

    @Override
    public Boolean RemoveEmployeeById(Integer id) {

        Boolean deleted = true;
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            deleted = false;
        }

        return deleted;
    }

    public Boolean createEmployee(Employee employee) {
        Employee save = employeeRepo.save(employee);
        return save.getId() > 0;
    }
}