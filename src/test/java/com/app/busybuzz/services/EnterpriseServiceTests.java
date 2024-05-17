package com.app.busybuzz.services;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.imp.AddressServiceIMP;
import com.app.busybuzz.services.imp.EnterpriseServiceIMP;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class EnterpriseServiceTests {

    @Autowired
    private IEnterpriseService enterpriseService;

    @Autowired
    private IOwnerService ownerService;

    @Autowired
    private IAddressService addressService;

    @Test
    @Order(1)
    public void shouldCreateOneEnterprise() {
        List<Owner> owners = new ArrayList<>();
        Address address = new Address();
        Enterprise newEntreprise = new Enterprise();

        Optional<Owner> owner = ownerService.findOneById(104);
        owners.add(owner.get());

        address.setNumber("558");
        address.setStreetName("rue de Gand");
        address.setCity("Croix");
        address.setZipCode("5900");


        newEntreprise.setName("enterprise 11");
        newEntreprise.setSiren(110365);
        newEntreprise.setVoteScore(0);
        newEntreprise.setPhoneNumber("019330");
        newEntreprise.setAddress(address);
        newEntreprise.setOwners(owners);

        addressService.save(address);
        enterpriseService.save(newEntreprise);

        Optional<Enterprise> result = enterpriseService.findOneById(newEntreprise.getId());
        assertTrue(result.isPresent());

    }

    @Test
    @Order(2)
    public void shouldReturnOneEnterprise() {
        Optional<Enterprise> result = enterpriseService.findOneById(251);
        assertTrue(result.isPresent());
        assertEquals("enterprise 1", result.get().getName());
    }

    @Test
    @Order(3)
    public void shouldUpdateEnterpriseData() {
        Integer enterpriseId = 251;
        Optional<Enterprise> enterpriseToUpdate = enterpriseService.findOneById(enterpriseId);
        enterpriseToUpdate.get().setName("udpateTest");
        enterpriseService.update(enterpriseToUpdate.get());
        Optional<Enterprise> result = enterpriseService.findOneById(enterpriseId);
        assertNotNull(result);
        assertEquals("udpateTest" , result.get().getName());
    }

    @Test
    @Order(4)
    public void shouldReturnListOfEnterprises() {
        List<Enterprise> results = enterpriseService.findAll();
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    public void shouldDeleteEnterprise() {
        Integer id = 251;
        Optional<Enterprise> enterpriseToDelete = enterpriseService.findOneById(id);
        enterpriseService.delete(enterpriseToDelete.get());
        Optional<Enterprise> result = enterpriseService.findOneById(id);
        assertFalse(result.isPresent());
    }
}
