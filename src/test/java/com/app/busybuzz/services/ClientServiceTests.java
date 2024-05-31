package com.app.busybuzz.services;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.AppClient;
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
public class ClientServiceTests {

    @Autowired
    IClientService clientService;

    @Test
    @Order(1)
    public void shouldCreateOneClient() {
        AppClient client = new AppClient();
        client.setName("client");
        client.setLastName("Test");
        client.setMail("client2@gmail.com");
        client.setRole(Roles.CLIENT);
        clientService.save(client);
        assertNotNull(client.getId());
    }

    @Test
    @Order(2)
    public void shouldReturnOneClient() {
        Integer expectedId = 119;
        Optional<AppClient> userFind = clientService.findOneById(expectedId);
        assertNotNull(userFind);
        assertEquals(expectedId, userFind.get().getId());
    }

    @Test
    @Order(3)
    public void shouldUpdateClientData() {
        Integer userId = 119;
        Optional<AppClient> userToUpdate = clientService.findOneById(userId);
        userToUpdate.get().setName("udpate");
        clientService.save(userToUpdate.get());
        Optional<AppClient> result = clientService.findOneById(userId);
        assertNotNull(result);
        assertEquals("udpate" , result.get().getName());
    }

    @Test
    @Order(4)
    public void shouldReturnListOfClients() {
        List<AppClient> results = clientService.findAll();
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    public void testSearchClientByEmail_shouldReturnOneClient() {
        Optional<AppClient> result = clientService.findOneByMail("client2@gmail.com");
        assertNotNull(result.get());
        assertEquals("client2@gmail.com", result.get().getMail());

    }

    @Test
    @Order(6)
    public void shouldDeleteOneClient() {
        Integer id = 119;
        Optional<AppClient> userToDelete = clientService.findOneById(id);
        clientService.delete(userToDelete.get());
        Optional<AppClient> result = clientService.findOneById(id);
        assertFalse(result.isPresent());
    }
}
