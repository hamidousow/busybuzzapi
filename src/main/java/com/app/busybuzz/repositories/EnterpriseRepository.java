package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Integer> {
}
