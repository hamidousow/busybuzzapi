package com.app.busybuzz.repositories;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommentRepositoryTests {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository appClientRepository;

    Faker faker = new Faker();

    Enterprise enterprise;

    Owner owner;

    List<Owner> owners;

    Address address;

    Comment comment;

    AppClient client;


    @BeforeEach
    public void initObjects() {

        client = new AppClient(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress()
        );

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

        appClientRepository.save(client);

        addressRepository.save(address);
        ownerRepository.save(owner);
        enterpriseRepository.save(enterprise);

        comment = new Comment(
                Date.from(Instant.now()),
                faker.lorem().paragraph(),
                enterprise,
                client
        );

        commentRepository.save(comment);

    }

    @AfterEach
    public void resetTable() {
        commentRepository.deleteAll();
        appClientRepository.deleteAll();
        enterpriseRepository.deleteAll();
        addressRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void commentRepository_shouldCreateOneComment_returnSavedComment() {
        Comment comment2 = new Comment(
                Date.from(Instant.now()),
                faker.lorem().paragraph(),
                enterprise,
                client
        );

        Comment result = commentRepository.save(comment2);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void commentRepository_testSearchCommentById_shouldReturnOneComment() {

        Optional<Comment> result = commentRepository.findById(comment.getId());

        assertThat(result).isPresent();
    }

    @Test
    @Order(3)
    public void commentRepository_testUpdateComment_shouldReturnComment() {
        comment.setText("test update");
        Comment resultSaved = commentRepository.save(comment);
        assertThat(resultSaved.getText()).isNotNull();
        assertThat(resultSaved.getText()).isEqualTo("test update");
    }

    @Test
    @Order(4)
    public void commentRepository_testFindAllComments_shouldReturnListOfComments() {
        Comment comment2 = new Comment(
                Date.from(Instant.now()),
                faker.lorem().paragraph(),
                enterprise,
                client
        );
        commentRepository.save(comment2);

        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        assertThat(comments.size()).isGreaterThan(1);
        comments.forEach(System.out::println);
    }

    @Test
    @Order(6)
    public void commentRepository_testDeleteComment_shouldDeleteOneComment() {
        commentRepository.deleteById(comment.getId());
        Optional <Comment> result = commentRepository.findById(comment.getId());

        assertThat(result).isEmpty();
    }
}
