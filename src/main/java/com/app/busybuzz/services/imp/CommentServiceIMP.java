package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Comment;
import com.app.busybuzz.repositories.CommentRepository;
import com.app.busybuzz.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceIMP implements ICommentService {

    CommentRepository commentRepository;

    public CommentServiceIMP(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void create(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findOneById(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }
}
