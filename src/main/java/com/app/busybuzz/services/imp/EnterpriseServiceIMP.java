package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.repositories.EnterpriseRepository;
import com.app.busybuzz.services.IEnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceIMP implements IEnterpriseService {

    EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceIMP(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public void save(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public Optional<Enterprise> findOneById(Integer id) {
        return enterpriseRepository.findById(id);
    }

    @Override
    public List<Enterprise> findAll() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public void delete(Enterprise enterprise) {
        enterpriseRepository.delete(enterprise);
    }

    /*@Override
    public void addOwner(Owner owner, Integer idEnterprise ) {
        Optional<Enterprise> enterprise = findOneById(idEnterprise);
        enterprise.get().getOwners().add(owner);
        save(enterprise.get());
    }*/
}
