package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.backend.pojos.enums.Departments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Component
public class EmployeeDTO {

    private Long empid;
   
    private String fname;
   
    private String lname;
  
    private String address;

    private Departments department;
    
    private String phoneNumber;
    
    private double salary;

   
    private LocalDate  joiningDate;
}
