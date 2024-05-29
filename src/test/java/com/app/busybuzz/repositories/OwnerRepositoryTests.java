package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class OwnerRepositoryTests {

    @Autowired
    private OwnerRepository ownerRepo;

    //todo: call before each to delete data in owner table
    @AfterEach
    public void resetTable() {
        ownerRepo.deleteAll();
    }


    @Test
    @Order(1)
    public void ownerRepository_shouldCreateOwner_returnSavedOwner() {
        Owner owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);

        ownerRepo.save(owner);

        assertThat(owner).isNotNull();
        assertThat(owner.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void ownerRepository_testSearchUserByMail_shouldReturnOneUser() {
        Owner owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);

        ownerRepo.save(owner);

        Optional<Owner> ownerFind = ownerRepo.findOneByMail(owner.getMail());

        assertThat(ownerFind).isPresent();

    }

    @Test
    @Order(3)
    public void ownerRepository_shouldUpdateUserData() {
        Owner owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);

        ownerRepo.save(owner);

        Optional<Owner> ownerUpdated = ownerRepo.findById(owner.getId());
        ownerUpdated.get().setName("updateTest");
        Owner resultSaved = ownerRepo.save(ownerUpdated.get());

        assertThat(resultSaved.getName()).isNotNull();
        assertThat(resultSaved.getName()).isEqualTo("updateTest");
    }

    @Test
    @Order(4)
    public void ownerRepository_testFindAllOwners_shouldReturnListOfUsers() {
        List<Owner>owners = (List<Owner>) ownerRepo.findAll();
        assertThat(owners.size()).isGreaterThan(0);
        System.out.println(owners);
    }

    @Test
    @Order(5)
    public void ownerRepository_testSearchUserById_shouldReturnOneUser() {

        Optional<Owner> ownerFind = ownerRepo.findById(104);

        assertThat(ownerFind.get()).isNotNull();
    }

    @Test
    @Order(6)
    public void ownerRepository_testDeleteOwner_shouldDeleteUser() {

        Owner owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);

        ownerRepo.save(owner);

        ownerRepo.delete(owner);
        Optional<Owner> ownerReturned = ownerRepo.findById(owner.getId());

        assertThat(ownerReturned).isEmpty();
    }
}
