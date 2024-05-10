package com.app.busybuzz.services;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Employee;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class EmployeeServiceTests {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Test
    @Order(1)
    public void shouldCreateNewEmployee() {
        Employee employee = new Employee("emp", "first", "employee1@createmethod.com");
        employee.setRole(Roles.EMPLOYEE);

        employee.setEnterprise(enterpriseService.findOneById(301).get());

        employeeService.create(employee);
        Optional<Employee> result = employeeService.findOneById(employee.getId());
        assertNotNull(result);
        assertEquals(employee.getName(), result.get().getName());
        assertEquals("employee", result.get().getRole());
    }

    @Test
    @Order(2)
    public void shouldReturnOneEmployee() {
        Integer expectedId = 113;
        Optional<Employee> userFind = employeeService.findOneById(expectedId);
        assertNotNull(userFind);
        assertEquals(expectedId, userFind.get().getId());
    }

    @Test
    @Order(3)
    public void shouldUpdateUserData() {
        Integer userId = 113;
        Optional<Employee> userToUpdate = employeeService.findOneById(userId);
        userToUpdate.get().setName("employeeUpdated");
        employeeService.update(userToUpdate.get());
        Optional<Employee> result = employeeService.findOneById(userId);
        assertNotNull(result);
        assertEquals("employeeUpdated" , result.get().getName());
    }

    @Test
    @Order(4)
    public void shouldReturnListOfEmployee() {
        List<Employee> results = employeeService.findAll();
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    public void testSearchEmployeeByEmail_shouldReturnOneUser() {
        Optional<Employee> result = employeeService.findOneByMail("employee1@createmethod.com");
        assertNotNull(result.get());
        assertEquals("employee1@createmethod.com", result.get().getMail());

    }

    @Test
    @Order(6)
    public void shouldDeleteUser() {
        Integer id = 113;
        Optional<Employee> userToDelete = employeeService.findOneById(id);
        employeeService.delete(userToDelete.get());
        Optional<Employee> result = employeeService.findOneById(id);
        assertFalse(result.isPresent());
    }
}
