package com.gfg.spring.boot.app.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {

    private int id;
    private String name;
    private String email;
    private int age;
    private AddressResponse addressResponse;

}
