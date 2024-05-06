package com.app.busybuzz.services;

import com.app.busybuzz.models.Owner;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerServiceTests {

    @Autowired
    private IOwnerService ownerService;

    @Test
    @Order(1)
    public void shouldCreateUserWithRoleOwner() {
        Owner owner = new Owner("test", "create", "test5@createmethod.com");
        ownerService.create(owner);
        Optional<Owner> result = ownerService.findOneById(owner.getId());
        assertNotNull(result);
        assertEquals(owner.getName(), result.get().getName());
        assertEquals("owner", result.get().getRole());

    }

    @Test
    @Order(2)
    public void shouldReturnOneUser() {
        Integer expectedId = 101;
        Optional<Owner> userFind = ownerService.findOneById(expectedId);
        assertNotNull(userFind);
        assertEquals(expectedId, userFind.get().getId(), "");
    }

    @Test
    @Order(3)
    public void shouldUpdateUserData() {
        Integer userId = 102;
        Optional<Owner> userToUpdate = ownerService.findOneById(userId);
        userToUpdate.get().setName("udpateTest");
        ownerService.update(userToUpdate.get());
        Optional<Owner> result = ownerService.findOneById(userId);
        assertNotNull(result);
        assertEquals("udpateTest" , result.get().getName());
    }

    @Test
    @Order(4)
    public void shouldReturnListOfUsers() {
        List<Owner> results = ownerService.findAll();
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    public void testSearchUserByEmail_shouldReturnOneUser() {
        Optional<Owner> result = ownerService.findOneByMail("test@gmail.com");
        assertNotNull(result.get());
        assertEquals("test@gmail.com", result.get().getMail());

    }

    @Test
    @Order(6)
    public void shouldDeleteUser() {
        Integer id = 110;
        Optional<Owner> userToDelete = ownerService.findOneById(id);
        ownerService.delete(userToDelete.get());
        Optional<Owner> result = ownerService.findOneById(id);
        assertFalse(result.isPresent());
    }
}
