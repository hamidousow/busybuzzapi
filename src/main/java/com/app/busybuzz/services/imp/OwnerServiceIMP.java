package com.app.busybuzz.services.imp;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.repositories.OwnerRepository;
import com.app.busybuzz.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OwnerServiceIMP implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void create(Owner owner) {
        owner.setRole(Roles.OWNER);
        ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findOneById(Integer id) {
        return ownerRepository.findById(id);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAll() {
        return (List<Owner>) ownerRepository.findAll();
    }



    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public Optional<Owner> findOneByMail(String email) {
        Optional<Owner> result = ownerRepository.findOneByMail(email);
        if(result.isEmpty()) {
            return null;
        }
        return result;
    }
}
