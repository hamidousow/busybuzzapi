package com.app.busybuzz.services;

import com.app.busybuzz.models.Comment;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentServiceTests {

    @Autowired
    ICommentService commentService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IPersonService personService;

    @Test
    public void shouldCreateComment() {
        Optional<Enterprise> enterprise = enterpriseService.findOneById(301);
        Optional<Person> person = personService.findOneById(104);
        Comment comment = new Comment();
        comment.setText("First comment");
        comment.setCreationDate(Date.from(Instant.now()));
        comment.setEnterprise(enterprise.get());
        comment.setPerson(person.get());

        commentService.create(comment);
    }

    @Test
    public void shouldFindOneComment() {
        Optional<Comment> result = commentService.findOneById(19);
        assertTrue(result.isPresent());
    }

    @Test
    public void shouldUpdateOneComment() {
        Integer commentId = 20;
        Optional<Comment> commentToUpdate = commentService.findOneById(commentId);
        commentToUpdate.get().setText("udpate comment test");
        commentService.update(commentToUpdate.get());
        Optional<Comment> result = commentService.findOneById(commentToUpdate.get().getId());
        assertNotNull(result);
        assertEquals("udpate comment test" , result.get().getText());
    }

    @Test
    public void shouldDeleteOneComment() {
        Optional<Comment> comment = commentService.findOneById(20);
        commentService.delete(comment.get());
        Optional<Comment> result =commentService.findOneById(comment.get().getId());
        assertTrue(result.isEmpty());
    }

}
