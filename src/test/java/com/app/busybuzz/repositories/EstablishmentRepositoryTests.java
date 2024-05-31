package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Establishment;
import com.app.busybuzz.models.Owner;
import com.github.javafaker.Faker;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EstablishmentRepositoryTests {

    @Inject
    private OwnerRepository ownerRepository;

    @Inject
    private EnterpriseRepository enterpriseRepository;

    @Inject
    private AddressRepository addressRepository;

    @Inject
    private EstablishmentRepository establishmentRepository;

    Faker faker = new Faker();

    Enterprise enterprise;

    Owner owner;

    List<Owner> owners;

    Address address;

    Establishment establishment;

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

        establishment = new Establishment(
                faker.company().industry(),
                String.valueOf(faker.number().numberBetween(1000,1999)),
                address,
                enterprise
        );

        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);
        establishmentRepository.save(establishment);
    }

    @AfterEach
    public void resetTable() {
        establishmentRepository.deleteAll();
        enterpriseRepository.deleteAll();
        addressRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void establishmentRepository_shouldCreateOneEstablishment_returnSavedEstablishment() {

        Address addressEstablishment = new Address(
                faker.address().streetAddressNumber(),
                faker.address().streetName(),
                faker.address().city(),
                faker.address().zipCode()
        );

        Establishment establishment2 = new Establishment(
                faker.company().industry(),
                String.valueOf(faker.number().numberBetween(1000,1999)),
                addressEstablishment,
                enterprise
        );

        addressRepository.save(addressEstablishment);
        Establishment result = establishmentRepository.save(establishment2);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void establishmentRepository_testSearchEstablishmentById_shouldReturnOneEstablishment() {

        Optional<Establishment> result = establishmentRepository.findById(establishment.getId());

        assertThat(result).isPresent();
    }

    @Test
    @Order(3)
    public void establishmentRepository_testUpdateEstablishment_shouldUpdateEstablishment() {
        establishment.setMainActivity("test update");
        Establishment resultSaved = establishmentRepository.save(establishment);
        assertThat(resultSaved.getMainActivity()).isNotNull();
        assertThat(resultSaved.getMainActivity()).isEqualTo("test update");
    }

    @Test
    @Order(4)
    public void EstablishmentRepository_testFindAllEstablishments_shouldReturnListOfEstablishments() {
        Address addressEstablishment = new Address(
                faker.address().streetAddressNumber(),
                faker.address().streetName(),
                faker.address().city(),
                faker.address().zipCode()
        );

        Establishment establishment2 = new Establishment(
                faker.company().industry(),
                String.valueOf(faker.number().numberBetween(1000,1999)),
                addressEstablishment,
                enterprise
        );

        addressRepository.save(addressEstablishment);
        Establishment result = establishmentRepository.save(establishment2);

        List<Establishment> establishments = (List<Establishment>) establishmentRepository.findAll();

        assertThat(establishments.size()).isGreaterThan(1);
        establishments.forEach(System.out::println);
    }

    @Test
    @Order(6)
    public void establishmentRepository_testDeleteEstablishment_shouldDeleteOneEstablishment() {
        establishmentRepository.deleteById(establishment.getId());
        Optional <Establishment> result = establishmentRepository.findById(establishment.getId());

        assertThat(result).isEmpty();
    }
}
