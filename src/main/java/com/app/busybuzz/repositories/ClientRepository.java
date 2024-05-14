package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Client;
import com.app.busybuzz.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findOneByMail(String mail);
}
