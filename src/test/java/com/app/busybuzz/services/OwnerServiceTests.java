package com.app.busybuzz.services;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.repositories.OwnerRepository;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerServiceTests {

    @Mock
    private OwnerRepository ownerRepoMock;

    @InjectMocks
    private OwnerServiceIMP ownerService;

    @Test
    @Order(1)
    public void shouldCreateUserWithRoleOwner() {
        Owner owner = new Owner();
        owner.setName("test");
        owner.setLastName("create");
        owner.setMail("test78@createmethod.com");
        owner.setRole(Roles.OWNER);
        ownerService.create(owner);
        verify(ownerRepoMock, times(1)).save(owner);
    }

    @Test
    @Order(2)
    public void searchUserByMail_shouldReturnOneUser() {
        Owner owner = new Owner();
        owner.setName("test");
        owner.setLastName("create");
        owner.setMail("test78@createmethod.com");
        owner.setRole(Roles.OWNER);
        given(ownerRepoMock.findOneByMail(owner.getMail()))
                .willReturn(Optional.of(owner));
        var ownerResult = ownerService.findOneByMail(owner.getMail());
        assertThat(ownerResult).isPresent();
    }

    @Test
    @Order(3)
    public void shouldUpdateUserData() {
        Owner owner = new Owner();
        owner.setName("test");
        owner.setLastName("create");
        owner.setMail("test78@createmethod.com");
        owner.setRole(Roles.OWNER);
        ownerService.create(owner);
        owner.setName("udpateTest");
        ownerService.update(owner);
        verify(ownerRepoMock, times(2)).save(owner);
    }

    @Test
    @Order(4)
    public void shouldReturnListOfUsers() {
        Owner owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);
        Owner owner2 = new Owner("owner2", "create2", "test782@createmethod.com", Roles.OWNER );

        List<Owner> owners = new ArrayList<Owner>(){{
            add(owner);
            add(owner2);
        }};
        given(ownerService.findAll()).willReturn(owners);

    }

    @Test
    @Order(5)
    public void testSearchUserById_shouldReturnOneUser() {
        Owner owner = new Owner();
        owner.setName("test");
        owner.setLastName("create");
        owner.setMail("test78@createmethod.com");
        owner.setRole(Roles.OWNER);
        given(ownerService.findOneById(1)).willReturn(Optional.of(owner));
    }

    @Test
    @Order(6)
    public void shouldDeleteUser() {

        Owner owner = new Owner();
        owner.setName("test");
        owner.setLastName("create");
        owner.setMail("test78@createmethod.com");
        owner.setRole(Roles.OWNER);
        ownerService.delete(owner);
        verify(ownerRepoMock, times(1)).delete(owner);
    }
}
