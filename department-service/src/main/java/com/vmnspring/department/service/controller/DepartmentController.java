package com.vmnspring.department.service.controller;

import com.vmnspring.department.service.entity.Department;
import com.vmnspring.department.service.error.DepartmentNotFoundException;
import com.vmnspring.department.service.service.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.findByDepartmentById(departmentId);
    }

    @DeleteMapping("/{id}")
    public Department deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentById(departmentId);
        return departmentService.findByDepartmentById(departmentId);
    }

}
