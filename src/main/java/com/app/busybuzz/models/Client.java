package com.app.busybuzz.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;


@Entity
@Component
@DiscriminatorValue("client")
@Table(name = "t_client")
public class Client extends Person {

    @Column(name = "cli_has_voted")
    private Boolean hasVoted;

    public Client() {}
}
