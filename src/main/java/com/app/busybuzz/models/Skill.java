package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_skill")
public class Skill {

    @Id
    @Column(name ="skil_id")
    @SequenceGenerator(name = "skill_id_seq_gen", sequenceName = "skill_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "skill_id_seq_gen", strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name ="skil_name")
    String name;

    /*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    List<Person> personList;*/

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
