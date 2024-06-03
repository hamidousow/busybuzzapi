package com.app.busybuzz.repositories;


import com.app.busybuzz.models.Address;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AddressRepositoryTests {

    @Autowired
    private AddressRepository addressRepository;

    Address address;

    Faker faker = new Faker();

    @BeforeEach
    public void initObjects() {

        address = new Address(
                faker.address().streetAddressNumber(),
                faker.address().streetName(),
                faker.address().city(),
                faker.address().zipCode()
        );
    }

    @AfterEach
    public void resetTable() {
        addressRepository.deleteAll();
    }
}
