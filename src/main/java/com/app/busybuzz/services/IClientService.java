package com.app.busybuzz.services;

import com.app.busybuzz.models.Client;
import com.app.busybuzz.models.Owner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    Optional<Client> findOneById(Integer id);

    void save(Client client);

    List<Client> findAll();

    void delete(Client client);

    Optional<Client> findOneByMail(String mail);
}
