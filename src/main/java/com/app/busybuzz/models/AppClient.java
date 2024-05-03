package com.app.busybuzz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "t_client")
public class AppClient extends Person {
    public AppClient(String name, String lastName, String mail) {
        super(name, lastName, mail);
    }
}
