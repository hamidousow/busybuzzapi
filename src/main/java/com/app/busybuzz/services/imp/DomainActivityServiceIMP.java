package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.DomainActivity;
import com.app.busybuzz.repositories.DomainActivityRepository;
import com.app.busybuzz.services.IDomainActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomainActivityServiceIMP implements IDomainActivityService {
    @Autowired
    DomainActivityRepository domainActivityRepository;

    @Override
    public void save(DomainActivity domain) {
        domainActivityRepository.save(domain);
    }

    @Override
    public Optional<DomainActivity> findOneByName(String name) {
        return domainActivityRepository.findByName(name);
    }

    @Override
    public Optional<DomainActivity> findOneById(Integer id) {
        return domainActivityRepository.findById(id);
    }

    @Override
    public void delete(DomainActivity domain) {
        domainActivityRepository.delete(domain);
    }

    @Override
    public List<DomainActivity> findAll() {
        return (List<DomainActivity>) domainActivityRepository.findAll();
    }
}
