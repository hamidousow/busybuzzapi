package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    Optional<Owner> findOneByMail(String email);
}
