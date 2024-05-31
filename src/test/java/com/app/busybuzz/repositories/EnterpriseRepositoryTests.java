package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;

import com.github.javafaker.Faker;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
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

    Faker faker = new Faker();

    Enterprise enterprise;

    Owner owner;

    List<Owner> owners;

    Address address;


    @BeforeEach
    public void initObjects() {
        address = new Address(
                faker.address().streetAddressNumber(),
                faker.address().streetName(),
                faker.address().city(),
                faker.address().zipCode()
        );

        owner = new Owner(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                Roles.OWNER
        );

        owners = new ArrayList<>(){{
            add(owner);
        }};

        enterprise = new Enterprise(
                faker.company().name(),
                faker.number().numberBetween(1000, 9999),
                faker.phoneNumber().cellPhone(),
                address,
                owners
        );

        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);
    }

    @AfterEach
    public void resetTable() {
        enterpriseRepository.deleteAll();
        addressRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void enterpriseRepository_shouldCreateOneEnterprise_returnSavedEnterprise() {
        Enterprise enterprise2 = new Enterprise(
                faker.company().name(),
                faker.number().numberBetween(1000, 9999),
                faker.phoneNumber().cellPhone(),
                address,
                owners
        );

        Enterprise result = enterpriseRepository.save(enterprise2);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void enterpriseRepository_testSearchEnterpriseById_shouldReturnOneEnterprise() {

        Optional<Enterprise> result = enterpriseRepository.findById(enterprise.getId());

        assertThat(result).isPresent();
    }

    @Test
    @Order(3)
    public void enterpriseRepository_testUpdateENterprise_shouldUpdateEnterpriseData() {
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
        enterpriseRepository.deleteById(enterprise.getId());
        Optional <Enterprise> result = enterpriseRepository.findById(enterprise.getId());

        assertThat(result).isEmpty();
    }


}
