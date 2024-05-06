package com.app.busybuzz.services;

import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.IEnterpriseService;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void shouldCreateOneEnterprise() {
        Optional<Owner> owner = ownerService.findOneById(101);
        Enterprise newEntreprise = Enterprise.builder()
                                    .name("enterprise 1")
                                    .siren(12345)
                                    .siret(678910)
                                    .voteScore(0)
                                    .phoneNumber("01200300400")
                                    .owner(owner.get())
                                    .build();
        enterpriseService.create(newEntreprise);
        Optional<Enterprise> result = enterpriseService.findOneById(newEntreprise.getId());
        assertTrue(result.isPresent());
        assertEquals("enterprise 1", result.get().getName());

    }

    @Test
    public void shouldReturnOneEnterprise() {
        Optional<Enterprise> result = enterpriseService.findOneById(251);
        assertTrue(result.isPresent());
        assertEquals("enterprise 1", result.get().getName());
    }
}
