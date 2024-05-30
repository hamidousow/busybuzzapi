package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Table(name = "t_owner")
@DiscriminatorValue("owner")
public class Owner extends Person {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "t_asso_enterprise_owner",
            joinColumns = @JoinColumn(name = "per_id"),
            inverseJoinColumns = @JoinColumn(name = "ent_id")
    )
    private List<Enterprise> enterprises;

    public Owner() {}

    public Owner(String name, String lastname, String mail, String role) {
        super(name, lastname, mail, role);
    }

    public Owner(String name,
                 String lastname,
                 String mail,
                 String role,
                 String position,
                 List<Comment> comments,
                 List<Skill> skills,
                 List<Enterprise> enterprises) {
        super(name, lastname, mail, role, position, comments, skills);
        this.enterprises = enterprises;
    }

    public List<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }
}
