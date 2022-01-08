package com.vmnspring.department.service.controller;

import com.vmnspring.department.service.entity.Department;
import com.vmnspring.department.service.service.DepartmentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("ML")
                .departmentAddress("Coimbatore")
                .departmentCode("CS6240")
                .departmentId(1L)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("ML")
                .departmentAddress("Coimbatore")
                .departmentCode("CS6240")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"departmentName\": \"ML\",\n" +
                        "  \"departmentAddress\": \"Coimbatore\",\n" +
                        "  \"departmentCode\": \"CS6240\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}