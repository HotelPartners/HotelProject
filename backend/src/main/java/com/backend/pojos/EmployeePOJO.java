package com.backend.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.backend.pojos.enums.Departments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="employee")
public class EmployeePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empid;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column(name="address")
    private String address;

   
    // @ManyToOne
    // @JoinColumn(name = "department_id")
    // private DepartmentPOJO department;
    
    @Enumerated(EnumType.STRING)
    private Departments department;
    
    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name = "salary")
    private double salary;

    @Column(name="joining_date")
    private LocalDate joiningDate;
}
