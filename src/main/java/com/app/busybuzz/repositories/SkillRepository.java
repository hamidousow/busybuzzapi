package com.app.busybuzz.repositories;

import com.app.busybuzz.models.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
    Optional<Skill> findByName(String name);
}
