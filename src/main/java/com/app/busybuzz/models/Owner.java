package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "t_owner")
@DiscriminatorValue("owner")
public class Owner extends Person {

    @ManyToMany
    @JoinTable(
            name = "t_asso_enterprise_owner",
            joinColumns = @JoinColumn(name = "per_id"),
            inverseJoinColumns = @JoinColumn(name = "ent_id")
    )
    private List<Enterprise> enterprises;

    public Owner() { }

    public Owner(String name, String lastName, String mail) {
        super(name, lastName, mail);
    }

    public void addEnterprise(Enterprise enterprise) {
        this.enterprises.add(enterprise);
    }




}
