package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
