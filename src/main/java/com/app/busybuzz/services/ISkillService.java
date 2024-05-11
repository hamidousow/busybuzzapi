package com.app.busybuzz.services;

import com.app.busybuzz.models.Comment;
import com.app.busybuzz.models.Skill;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ISkillService {

    void create(Skill skill);

    void save(Skill skill);

    Optional<Skill> findOneByName(String name);

    Set<Skill> findAll();

    void delete(Skill skill);

    Optional<Skill> findOneById(Integer id);

    void update(Skill skill);
}
