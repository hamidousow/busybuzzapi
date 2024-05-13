package com.app.busybuzz.services;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IAddressService {


    void save(Address address);

    Optional<Address> findOneById(Integer id);

    void create(Address address);

    void delete(Address address);
}
