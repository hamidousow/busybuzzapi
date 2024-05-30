package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "t_employee")
@DiscriminatorValue("employee")
public class Employee extends Person {

    @ManyToOne(targetEntity = Enterprise.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ent_id")
    Enterprise enterprise;

    public Employee() {}

    public Employee(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


}
