package com.app.busybuzz.services;

import com.app.busybuzz.models.Enterprise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEnterpriseService {

    void save(Enterprise enterprise);

    Optional<Enterprise> findOneById(Integer id);

    List<Enterprise> findAll();

    void update(Enterprise enterprise);

    void delete(Enterprise enterprise);

    //void addOwner(Owner owner, Integer idEnterprise);
}
