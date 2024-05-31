package com.app.busybuzz.repositories;

import com.app.busybuzz.models.AppClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClientRepository extends CrudRepository<AppClient, Integer> {
    Optional<AppClient> findOneByMail(String mail);
}
