package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.repositories.AddressRepository;
import com.app.busybuzz.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceIMP implements IAddressService {

    @Autowired
    AddressRepository addressRepository;


    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Optional<Address> findOneById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public void create(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
