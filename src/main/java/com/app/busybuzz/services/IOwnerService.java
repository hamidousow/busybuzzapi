package com.app.busybuzz.services;

import com.app.busybuzz.models.Owner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IOwnerService {

    void create(Owner owner);

    Optional<Owner> findOneById(Integer id);

    void update(Owner owner);

    List<Owner> findAll();

    void delete(Owner owner);

    Optional<Owner> findOneByMail(String email);
}
