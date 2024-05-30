package com.app.busybuzz.repositories;

import com.app.busybuzz.models.DomainActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DomainActivityRepository extends CrudRepository<DomainActivity, Integer> {
    Optional<DomainActivity> findByName(String name);
}
