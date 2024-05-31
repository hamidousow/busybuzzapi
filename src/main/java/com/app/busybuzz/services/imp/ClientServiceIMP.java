package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.AppClient;
import com.app.busybuzz.repositories.ClientRepository;
import com.app.busybuzz.services.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceIMP implements IClientService {


    ClientRepository clientRepository;

    public ClientServiceIMP(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public Optional<AppClient> findOneById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public void save(AppClient client) {
        clientRepository.save(client);
    }

    @Override
    public List<AppClient> findAll() {
        return (List<AppClient>) clientRepository.findAll();
    }

    @Override
    public void delete(AppClient client) {
        clientRepository.delete(client);
    }

    @Override
    public Optional<AppClient> findOneByMail(String mail) {
        return clientRepository.findOneByMail(mail);
    }
}
