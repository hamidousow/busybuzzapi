package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "t_enterprise")
public class Enterprise {

    @Id
    @Column(name = "ent_id")
    @SequenceGenerator(name = "enterprise_id_seq_gen", sequenceName = "enterprise_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_id_seq_gen")
    private Integer id;

    @Column(name = "ent_name")
    private String name;

    @Column(name = "ent_siren")
    private int siren;

    @Column(name = "ent_vote_score")
    private Integer voteScore;

    @Column(name = "ent_phone_number")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "t_asso_enterprise_owner",
            joinColumns = @JoinColumn(name = "ent_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id")
    )
    private List<Owner> owners;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
    List<Employee> employees;

    @OneToOne
    @JoinColumn(name = "addr_id", referencedColumnName = "addr_id")
    Address address;

    @OneToMany(mappedBy = "enterprise")
    List<Establishment> establishments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    List<Comment> comment;

    public Enterprise() {

    }

    public Enterprise(String name, int siren, String phoneNumber) {
        this.name = name;
        this.siren = siren;
        this.phoneNumber = phoneNumber;
    }
}
