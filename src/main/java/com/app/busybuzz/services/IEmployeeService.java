package com.app.busybuzz.services;

import com.app.busybuzz.models.Employee;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findOneById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findOneByMail(String mail) {
        return employeeRepository.findByMail(mail);
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
