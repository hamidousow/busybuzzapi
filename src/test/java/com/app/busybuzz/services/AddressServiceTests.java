package com.app.busybuzz.services;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressServiceTests {

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IAddressService addressService;

    @Test
    public void shouldCreateAddress() {
        Optional<Enterprise> enterprise = enterpriseService.findOneById(301);
        Address address = new Address();
        address.setNumber("8");
        address.setStreetName("rue du test adress");
        address.setCity("Croix");
        address.setZipCode("59000");
        address.setEnterprise(enterprise.get());

        addressService.create(address);
        Optional<Address> result = addressService.findOneById(address.getId());
        assertTrue(result.isPresent());
        assertEquals("48", result.get().getNumber());
    }

    @Test
    public void shouldReturnOneAddress() {
        Optional<Address> result = addressService.findOneById(151);
        assertTrue(result.isPresent());
        assertEquals("Lille", result.get().getCity());

    }

    @Test
    public void shouldUpdateOneAddress() {
        Optional<Address> result = addressService.findOneById(151);
        result.get().setCity("Croix");
        addressService.save(result.get());
        assertEquals("Croix", result.get().getCity());
    }

    @Test
    public void shouldDeleteOneAddress() {
        Optional<Address> result = addressService.findOneById(151);
        addressService.delete(result.get());
        Optional<Address> address = addressService.findOneById(151);
        assertTrue(address.isEmpty());
    }
}
