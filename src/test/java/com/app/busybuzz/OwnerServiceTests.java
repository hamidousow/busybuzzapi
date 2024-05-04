package com.app.busybuzz;

import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.IOwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OwnerServiceTests {

    @Autowired
    IOwnerService ownerService;

    @Test
    public void shouldCreateUserWithRoleOwner() {
        Owner owner = new Owner("test", "create", "test3@createmethod.com");
        ownerService.create(owner);
        Optional<Owner> result = ownerService.findOneById(owner.getId());
        assertNotNull(result);
        assertEquals("test", result.get().getName());
    }
}
