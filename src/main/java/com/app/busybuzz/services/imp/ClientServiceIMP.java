package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Client;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.repositories.ClientRepository;
import com.app.busybuzz.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Client> findOneById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public Optional<Client> findOneByMail(String mail) {
        return clientRepository.findOneByMail(mail);
    }
}
