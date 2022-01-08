package com.vmnspring.department.service.service;

import com.vmnspring.department.service.entity.Department;
import com.vmnspring.department.service.error.DepartmentNotFoundException;
import com.vmnspring.department.service.repository.DepartmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private  DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                                .departmentName("IT")
                                .departmentAddress("Coimbatore")
                                .departmentCode("CS6240")
                                .departmentId(123L)
                                .build();
        Mockito.when(departmentRepository.findByDepartmentId(123L))
                .thenReturn((department));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Get Valid Department by ID")
    public void whenValidDepartmentName_thenDepartmentNameFound() throws DepartmentNotFoundException {
        Long departmentId = 123L;
        Department found = departmentService.findByDepartmentById(departmentId);
        assertEquals(departmentId,found.getDepartmentId());

   }
}