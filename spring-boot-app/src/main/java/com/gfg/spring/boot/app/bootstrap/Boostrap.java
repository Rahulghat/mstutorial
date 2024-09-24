package com.gfg.spring.boot.app.bootstrap;


import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boostrap implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    void loadData(){

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();

        employee1.setId(1);
        employee2.setId(2);
        employee3.setId(3);
        employee4.setId(4);

        employee1.setAge(11);
        employee2.setAge(12);
        employee3.setAge(13);
        employee4.setAge(14);

        employee1.setEmail("test@gmail.com");
        employee2.setEmail("test2@gmail.com");
        employee3.setEmail("test3@gmail.com");
        employee4.setEmail("test4@gmail.com");

        employee1.setName("Anil");
        employee2.setName("Anild");
        employee3.setName("Anila");
        employee4.setName("Anilf");



        employeeService.createEmployee(employee1);
        employeeService.createEmployee(employee2);
        employeeService.createEmployee(employee3);
        employeeService.createEmployee(employee4);

    }
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

}
