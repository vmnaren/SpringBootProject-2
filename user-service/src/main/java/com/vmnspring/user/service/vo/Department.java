package com.vmnspring.user.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;

    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
