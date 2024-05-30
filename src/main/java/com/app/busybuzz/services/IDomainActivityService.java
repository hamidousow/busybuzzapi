package com.app.busybuzz.services;

import com.app.busybuzz.models.DomainActivity;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IDomainActivityService {

    void save(DomainActivity domain);

    Optional<DomainActivity> findOneByName(String name);

    Optional<DomainActivity> findOneById(Integer id);

    void delete(DomainActivity domain);

    List<DomainActivity> findAll();
}
