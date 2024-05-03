package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_person")
public class Person {

    @Id
    @Column(name = "per_id")
    private Integer Id;

    @Column(name = "per_name")
    private String name;

    @Column(name = "per_last_name")
    private String lastName;

    @Column(name = "per_mail")
    private String mail;

    @Column(name = "per_role")
    private String role;

    public Person(String name, String lastName, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }
}
