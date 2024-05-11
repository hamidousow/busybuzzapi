package com.app.busybuzz.services;

import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Comment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICommentService {

    void save(Comment comment);

    Optional<Comment> findOneById(Integer id);

    void create(Comment comment);

    void delete(Comment comment);

    void update(Comment comment);
}
