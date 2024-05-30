package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_enterprise")
public class Enterprise {

    @Id
    @Column(name = "ent_id")
    @SequenceGenerator(name = "enterprise_id_seq_gen", sequenceName = "enterprise_id_seq", allocationSize = 1)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "t_asso_enterprise_owner",
            joinColumns = @JoinColumn(name = "ent_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id")
    )
    private List<Owner> owners;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER)
    List<Employee> employees;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addr_id", referencedColumnName = "addr_id")
    Address address;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER)
    List<Establishment> establishments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enterprise", cascade = CascadeType.REMOVE)
    List<Comment> comment;

    public Enterprise() {
    }

    public Enterprise(String name, int siren, String phoneNumber, List<Owner> owners) {
        this.name = name;
        this.siren = siren;
        this.owners = owners;
        this.phoneNumber = phoneNumber;
    }

    public Enterprise(String name, int siren, Integer voteScore, String phoneNumber) {
        this.name = name;
        this.siren = siren;
        this.voteScore = voteScore;
        this.phoneNumber = phoneNumber;
    }

    public Enterprise(String name, int siren, String phoneNumber, Address address, List<Owner> owners) {
        this.name = name;
        this.siren = siren;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.owners = owners;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSiren() {
        return siren;
    }

    public void setSiren(int siren) {
        this.siren = siren;
    }

    public Integer getVoteScore() {
        return voteScore;
    }

    public void setVoteScore(Integer voteScore) {
        this.voteScore = voteScore;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
