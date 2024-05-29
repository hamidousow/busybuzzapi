package com.app.busybuzz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "t_client")
public class AppClient extends Person {
    public AppClient(
                     String name,
                     String lastname,
                     String mail,
                     String role) {
        super(name, lastname, mail, role);
    }
}
