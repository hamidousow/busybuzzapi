package com.app.busybuzz.services;

import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    @Order(1)
    public void shouldCreateOneEnterprise() {
        Optional<Owner> owner = ownerService.findOneById(104);
        Enterprise newEntreprise = Enterprise.builder()
                                    .name("enterprise 6")
                                    .siren(1252102)
                                    .siret(678012325)
                                    .voteScore(0)
                                    .phoneNumber("012023400")
                                    .owner(owner.get())
                                    .build();
        enterpriseService.create(newEntreprise);
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
