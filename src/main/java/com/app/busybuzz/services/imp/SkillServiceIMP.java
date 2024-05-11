package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Comment;
import com.app.busybuzz.models.Skill;
import com.app.busybuzz.repositories.SkillRepository;
import com.app.busybuzz.services.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class SkillServiceIMP implements ISkillService {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public void create(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> findOneByName(String name) {
        return skillRepository.findByName(name);
    }

    @Override
    public Set<Skill> findAll() {
        return (Set<Skill>) skillRepository.findAll();
    }

    @Override
    public void delete(Skill skill) {
        skillRepository.delete(skill);
    }

    @Override
    public Optional<Skill> findOneById(Integer id) {
        return skillRepository.findById(id);
    }

    @Override
    public void update(Skill skill) {
        skillRepository.save(skill);
    }
}
