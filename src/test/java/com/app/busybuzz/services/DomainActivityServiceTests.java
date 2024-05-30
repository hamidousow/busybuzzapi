package com.app.busybuzz.services;

import com.app.busybuzz.models.DomainActivity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DomainActivityServiceTests {

    @Autowired
    IDomainActivityService domainActivityService;

    @Test
    public void shouldCreateOneDomainActivity() {
        DomainActivity domain = new DomainActivity();
        domain.setName("Esthetic");
        domainActivityService.save(domain);
        assertNotNull(domain.getId());
    }

    @Test
    public void shouldReturnOneDomainActivity() {
        Optional<DomainActivity> domain = domainActivityService.findOneById(1);
        assertTrue(domain.isPresent());
        assertEquals("Esthetic", domain.get().getName());
    }

    @Test
    public void shouldUpdateDomainActivity() {
        Optional<DomainActivity> domain = domainActivityService.findOneById(1);
        domain.get().setName("Barber");
        domainActivityService.save(domain.get());
        assertEquals("Barber", domainActivityService.findOneById(1).get().getName());
    }

    @Test
    public void shouldReturnAllDomainsActivity() {
        List<DomainActivity> domainsList = domainActivityService.findAll();
        assertTrue(!domainsList.isEmpty());
    }

    @Test
    public void shouldDeleteOneDomain() {
        Optional<DomainActivity> domain = domainActivityService.findOneById(1);
        assertTrue(domain.isPresent());
        domainActivityService.delete(domain.get());
        Optional<DomainActivity> result = domainActivityService.findOneById(1);
        assertTrue(result.isEmpty());
    }
}
