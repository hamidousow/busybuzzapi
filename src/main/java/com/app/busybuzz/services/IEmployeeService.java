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
public interface IEmployeeService {

    void create(Employee employee);

    Optional<Employee> findOneById(Integer id);

    void update(Employee employee);

    Optional<Employee> findOneByMail(String mail);

    List<Employee> findAll();

    void delete(Employee employee);
}
