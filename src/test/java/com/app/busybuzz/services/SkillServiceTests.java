package com.app.busybuzz.services;

import com.app.busybuzz.models.Comment;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Person;
import com.app.busybuzz.models.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SkillServiceTests {

    @Autowired
    ICommentService commentService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IPersonService personService;

    @Autowired
    ISkillService skillService;

    @Test
    public void shouldCreateSkill() {
        Skill skill = new Skill();
        skill.setName("First Skill");
        skillService.create(skill);
        Optional<Skill> result = skillService.findOneByName("First Skill");
        assertTrue(result.isPresent());
    }

    @Test
    public void shouldFindOneSkillByName() {
        Optional<Skill> result = skillService.findOneByName("First Skill");
        assertTrue(result.isPresent());
    }

    @Test
    public void shouldUpdateOneSkill() {
        Optional<Skill> skill = skillService.findOneById(1);
        skill.get().setName("Update skill");
        skillService.update(skill.get());
        Optional<Skill> result = skillService.findOneById(skill.get().getId());
        assertNotNull(result);
        assertEquals("Update skill" , result.get().getName());
    }

    @Test
    public void shouldDeleteOneSkill() {
        Optional<Skill> skill = skillService.findOneById(1);
        skillService.delete(skill.get());
        Optional<Skill> result = skillService.findOneById(skill.get().getId());
        assertTrue(result.isEmpty());
    }
}
