package com.app.busybuzz.services;

import com.app.busybuzz.models.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {

    void create(Owner owner);

    Optional<Owner> findOneById(Integer id);

    void update(Owner owner);

    List<Owner> findAll();

    void delete(Owner owner);

    Optional<Owner> findOneByMail(String email);
}
