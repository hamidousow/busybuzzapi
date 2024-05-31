package com.app.busybuzz.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@DiscriminatorValue("client")
@Table(name = "t_client")
public class AppClient extends Person {

    @Column(name = "cli_has_voted")
    private Boolean hasVoted;

    public AppClient() {
    }

    public AppClient(
                     String name,
                     String lastname,
                     String mail) {
        super(name, lastname, mail);
    }
}
