package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_person")
public class Person {

    @Id
    @Column(name = "per_id")
    @SequenceGenerator(name = "person_id_seq_gen", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq_gen")
    private Integer Id;

    @Column(name = "per_name")
    private String name;

    @Column(name = "per_last_name")
    private String lastName;

    @Column(name = "per_mail")
    private String mail;

    @Column(name = "per_role")
    private String role;

    @Column(name = "per_position")
    private String position;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.REMOVE)
    List<Comment> comment;

    @ManyToMany
    @JoinTable(
            name = "t_asso_person_skill",
            joinColumns = @JoinColumn(name = "skil_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id"))
    List<Skill> skills;

    public Person() {

    }

    public Person(String name, String lastName, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }

}
