package com.app.busybuzz.services;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.repositories.AddressRepository;
import com.app.busybuzz.repositories.EnterpriseRepository;
import com.app.busybuzz.services.imp.AddressServiceIMP;
import com.app.busybuzz.services.imp.EnterpriseServiceIMP;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class AddressServiceTests {


    private EnterpriseRepository enterpriseRepoMock = mock(EnterpriseRepository.class);
    private AddressRepository addressRepoMock = mock(AddressRepository.class);

    private IEnterpriseService enterpriseService = new EnterpriseServiceIMP(enterpriseRepoMock);

    private IAddressService addressService = new AddressServiceIMP(addressRepoMock);

    @Test
    public void shouldCreateAddress() {
        Optional<Enterprise> enterprise = enterpriseService.findOneById(301);
        Address address = new Address();
        address.setNumber("8");
        address.setStreetName("rue du test adress");
        address.setCity("Croix");
        address.setZipCode("59000");

        addressService.save(address);
        Optional<Address> result = addressService.findOneById(address.getId());
        assertTrue(result.isPresent());
        assertEquals("48", result.get().getNumber());
    }

    @Test
    public void shouldReturnOneAddress() {
        Optional<Address> result = addressService.findOneById(251);
        assertTrue(result.isPresent());
        assertEquals("Croix", result.get().getCity());

    }

    @Test
    public void shouldUpdateOneAddress() {
        Optional<Address> result = addressService.findOneById(201);
        result.get().setCity("Croix");
        addressService.save(result.get());
        assertEquals("Croix", result.get().getCity());
    }

    @Test
    public void shouldDeleteOneAddress() {
        Optional<Address> result = addressService.findOneById(251);
        addressService.delete(result.get());
        Optional<Address> address = addressService.findOneById(251);
        assertTrue(address.isEmpty());
    }
}
