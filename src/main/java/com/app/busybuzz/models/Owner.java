package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "t_owner")
public class Owner extends Person {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Enterprise> enterprises;

    public Owner() { }

    public Owner(String name, String lastName, String mail) {
        super(name, lastName, mail);
    }


}
