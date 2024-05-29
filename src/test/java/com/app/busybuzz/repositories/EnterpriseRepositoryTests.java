package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.services.DatabaseTestCleanupService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
@SpringBootTest
public class EnterpriseRepositoryTests {

    @Inject
    private OwnerRepository ownerRepository;

    @Inject
    private EnterpriseRepository enterpriseRepository;

    @Inject
    private AddressRepository addressRepository;



    Enterprise enterprise;

    Owner owner;

    List<Owner> owners;

    Address address;

    @Container
    static PostgreSQLContainer<?> postgresSQLContainer = new PostgreSQLContainer<>("postgres:12.7")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("")
            .withInitScript("db/000_init_db_tables.sql");

    @BeforeAll
    static void beforeAll() {
        postgresSQLContainer.start();
    }

    @BeforeEach
    public void initObjects() {
        address = Address.builder()
                .number("27")
                .streetName("rue de la Latte")
                .city("Tourcoing")
                .zipCode("59200")
                .build();

        owner = new Owner("Ha","Mas","mail@gmail.com", Roles.OWNER);

        owners = new ArrayList<>(){{
            add(owner);
        }};

        enterprise = new Enterprise();
        enterprise.setName("enterprise2");
        enterprise.setOwners(owners);
        enterprise.setSiren(14559);
        enterprise.setPhoneNumber("0320423");

        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);
    }

    @AfterEach
    public void cleanup() {
        /*try {
            System.out.println("Second deleting database");
            dbCleanupService.resetData("t_enterprise");
            System.out.println("Second database deleted ! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }



    @AfterAll
    static void afterAll() {
        postgresSQLContainer.stop();
    }




    @Test
    @Order(1)
    public void enterpriseRepository_shouldCreateOneEnterprise_returnSavedEnterprise() {

        enterprise.setAddress(address);
        enterprise.setOwners(owners);
        Enterprise result = enterpriseRepository.save(enterprise);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void enterpriseRepository_testSearchEnterpriseById_shouldReturnOneEnterprise() {
        /*Address address = new Address("27", "Marceau", "Tourcoing", "59200");
        Owner owner = new Owner("test", "create", "test695@createmethod.com");
        Enterprise enterprise = Enterprise.builder()
                                    .address(address)
                                    .name("rolland")
                                    .siren(123456)
                                    .phoneNumber("123456")
                                    .build();
        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);*/

        Optional<Enterprise> result = enterpriseRepository.findById(enterprise.getId());

        assertThat(result).isPresent();

    }

    @Test
    @Order(3)
    public void enterpriseRepository_shouldUpdateEnterpriseData() {
        /*Address address = new Address("27", "Marceau", "Tourcoing", "59200");
        Owner owner = new Owner("test", "create", "ownermpg@createmethod.com");
        Enterprise enterprise = Enterprise.builder()
                .address(address)
                .name("rolland")
                .siren(16556)
                .phoneNumber("123456")
                .build();
        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);*/

        enterprise.setName("test update");
        Enterprise resultSaved = enterpriseRepository.save(enterprise);
        assertThat(resultSaved.getName()).isNotNull();
        assertThat(resultSaved.getName()).isEqualTo("test update");
    }

    @Test
    @Order(4)
    public void enterpriseRepository_testFindAllEnterprises_shouldReturnListOfEnterprises() {
        List<Enterprise> enterprises = (List<Enterprise>) enterpriseRepository.findAll();
        assertThat(enterprises.size()).isGreaterThan(0);
        enterprises.forEach(System.out::println);
    }

    @Test
    @Order(6)
    public void enterpriseRepository_testDeleteEnterprise_shouldDeleteOneEnterprise() {

        /*Address address = new Address("27", "Marceau", "Tourcoing", "59200");
        Owner owner = new Owner("test", "create", "own695@createmethod.com");
        Enterprise enterprise = Enterprise.builder()
                .address(address)
                .name("rolland")
                .siren(10006)
                .phoneNumber("123456")
                .build();
        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);*/

        enterpriseRepository.deleteById(enterprise.getId());
        Optional <Enterprise> result = enterpriseRepository.findById(enterprise.getId());
        assertThat(result).isEmpty();
    }


}
