package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Employee;
import com.app.busybuzz.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByMail(String mail);
}
