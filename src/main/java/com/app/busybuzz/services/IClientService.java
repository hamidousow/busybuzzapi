package com.app.busybuzz.services;

import com.app.busybuzz.models.AppClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    Optional<AppClient> findOneById(Integer id);

    void save(AppClient client);

    List<AppClient> findAll();

    void delete(AppClient client);

    Optional<AppClient> findOneByMail(String mail);
}
