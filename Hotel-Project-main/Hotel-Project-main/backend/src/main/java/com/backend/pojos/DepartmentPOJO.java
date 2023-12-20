package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name")
    private String deptName;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeePOJO> employees = new ArrayList<>();


    public void addEmployees(EmployeePOJO employeePOJO) {
        employees.add(employeePOJO);// parent --> child link
        employeePOJO.setDepartment(this);// child --> parent
    }

    public void removeEmoloyees(EmployeePOJO employeePOJO) {
        employees.remove(employeePOJO);// parent --> child link
        employeePOJO.setDepartment(null);// child ---X---> parent
    }


}
