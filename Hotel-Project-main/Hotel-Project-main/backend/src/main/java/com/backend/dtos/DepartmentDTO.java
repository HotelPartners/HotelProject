package com.backend.dtos;



import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class DepartmentDTO 
{
    private Long deptId;

    private String deptName;
}
