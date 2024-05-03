package com.app.busybuzz.models;

import jakarta.persistence.*;



@Entity
@Table(name = "t_owner")
public class Owner extends Person {
    public Owner(String name, String lastName, String mail) {
        super(name, lastName, mail);
    }
}
