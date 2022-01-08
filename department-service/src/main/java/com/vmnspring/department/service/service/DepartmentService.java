package com.vmnspring.department.service.service;

import com.vmnspring.department.service.entity.Department;
import com.vmnspring.department.service.error.DepartmentNotFoundException;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public Department findByDepartmentById(Long departmentId)  throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);
}
