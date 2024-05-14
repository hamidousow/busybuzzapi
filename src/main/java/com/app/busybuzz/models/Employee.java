package com.app.busybuzz.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "t_employee")
@DiscriminatorValue("employee")
public class Employee extends Person {

    @ManyToOne(targetEntity = Enterprise.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ent_id")
    Enterprise enterprise;

    public Employee() {

    }

    public Employee(String name, String lastname, String mail) {
        super(name, lastname, mail);
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
