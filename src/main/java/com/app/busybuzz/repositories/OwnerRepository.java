package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    Optional<Owner> findOneByMail(String email);

}
