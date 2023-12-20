package com.backend.dtos;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.backend.pojos.DepartmentPOJO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Component
public class EmployeeDTO {

      private Long empid;

   
    private String firstName;

    private String lastName;

    private String address;

    private String mobileNumber;
    
    private double salary;

    private LocalDate joiningDate;

    // private DepartmentPOJO department;

}
