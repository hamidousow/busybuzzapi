package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "per_role"
)
@Table(name = "t_person")
public class Person {

    @Id
    @Column(name = "per_id")
    @SequenceGenerator(name = "person_id_seq_gen", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq_gen")
    private Integer id;

    @Column(name = "per_name")
    private String name;

    @Column(name = "per_last_name")
    private String lastName;

    @Column(name = "per_mail")
    private String mail;

    @Column(name = "per_role", insertable=false, updatable=false)
    private String role;

    @Column(name = "per_position")
    private String position;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.REMOVE)
    List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_asso_person_skill",
            joinColumns = @JoinColumn(name = "skil_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id"))
    List<Skill> skills;

    public Person() {

    }

    public Person(String name, String lastname, String mail, String role) {
        this.name = name;
        this.lastName = lastname;
        this.mail = mail;
        this.role = role;
    }

    public Person(String name, String lastName, String mail, String role, String position, List<Comment> comments, List<Skill> skills) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.role = role;
        this.position = position;
        this.comments = comments;
        this.skills = skills;
    }

    public Person(String firstname, String lastname, String mail) {
        this.name = firstname;
        this.lastName = lastname;
        this.mail = mail;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
