package com.gfg.spring.boot.app.mapper;

import com.gfg.spring.boot.app.entity.Employee;
import com.gfg.spring.boot.app.response.EmployeeResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee EmployeeResponsetoEmployee(EmployeeResponse response);

    EmployeeResponse EmployeetoEmployeeResponse(Employee employee);

}
