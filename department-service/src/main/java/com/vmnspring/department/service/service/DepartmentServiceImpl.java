package com.vmnspring.department.service.service;

import com.vmnspring.department.service.entity.Department;
import com.vmnspring.department.service.error.DepartmentNotFoundException;
import com.vmnspring.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("Inside Department Service Save Department");
        return departmentRepository.save(department);
    }

    @Override
    public Department findByDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = Optional.ofNullable(departmentRepository.findByDepartmentId(departmentId));

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
