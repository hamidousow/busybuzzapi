package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.*;

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

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Owner owner;

    @BeforeEach
    public void initData() {
        ownerRepo.deleteAll();
        enterpriseRepository.deleteAll();
        addressRepository.deleteAll();
        owner = new Owner("owner", "create1", "test78@createmethod.com", Roles.OWNER);
        ownerRepo.save(owner);
    }

    @AfterEach
    public void resetTable() {
        ownerRepo.deleteAll();
    }

    @Test
    @Order(1)
    public void ownerRepository_shouldCreateOwner_returnSavedOwner() {
        Owner owner2 = new Owner("owner2", "hello2", "test8569652@createmethod.com", Roles.OWNER);
        Owner owner3 = new Owner("owner3", "create3", "test3@createmethod.com", Roles.OWNER);
        Owner owner4 = new Owner("owner4", "create4", "test4@createmethod.com", Roles.OWNER);
        Address address = new Address("27", "rue de la Latte", "Tourcoing", "59200");

        List<Owner> owners = new ArrayList<>(){{
            add(owner2);
            add(owner3);
            add(owner4);
        }};

        Enterprise enterprise = new Enterprise(
                "enterprise2",
                145598,
                "0320423",
                address,
                owners
        );

        addressRepository.save(address);
        ownerRepo.saveAll(owners);
        enterpriseRepository.save(enterprise);
        //ownerRepo.addEnterprise(enterprise);


        assertThat(owner2).isNotNull();
        assertThat(owner2.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void ownerRepository_testSearchUserByMail_shouldReturnOneUser() {

        Optional<Owner> ownerFind = ownerRepo.findOneByMail(owner.getMail());
        assertThat(ownerFind).isPresent();
    }

    @Test
    @Order(3)
    public void ownerRepository_shouldUpdateUserData() {
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
        Optional<Owner> ownerFind = ownerRepo.findById(owner.getId());
        assertThat(ownerFind.get()).isNotNull();
    }

    @Test
    @Order(6)
    public void ownerRepository_testDeleteOwner_shouldDeleteUser() {
        ownerRepo.delete(owner);
        Optional<Owner> ownerReturned = ownerRepo.findById(owner.getId());
        assertThat(ownerReturned).isEmpty();
    }

}
