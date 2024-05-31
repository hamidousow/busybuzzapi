package com.app.busybuzz.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_establishment")
public class Establishment {

    @Id
    @Column(name = "est_id")
    @SequenceGenerator(name = "establishment_id_seq_gen", sequenceName = "establishment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "establishment_id_seq_gen")
    private Integer id;

    @Column(name = "est_main_activity")
    private String mainActivity;

    @Column(name = "est_date_created")
    private String dateCreated;

    @Column(name = "est_date_activity_started")
    private String dateActivityStarted;

    @Column(name = "est_date_closed")
    private String dateClosed;

    @Column(name = "est_siret")
    private String siret;

    @OneToOne
    @JoinColumn(name = "addr_id", referencedColumnName = "addr_id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ent_id")
    private Enterprise enterprise;

    public Establishment() {
    }

    public Establishment(String mainActivity, String dateCreated, String dateActivityStarted, String dateClosed, String siret, Address address) {
        this.mainActivity = mainActivity;
        this.dateCreated = dateCreated;
        this.dateActivityStarted = dateActivityStarted;
        this.dateClosed = dateClosed;
        this.siret = siret;
        this.address = address;
    }

    public Establishment(String mainActivity, String dateCreated, String dateActivityStarted, String dateClosed, String siret, Address address, Enterprise enterprise) {
        this.mainActivity = mainActivity;
        this.dateCreated = dateCreated;
        this.dateActivityStarted = dateActivityStarted;
        this.dateClosed = dateClosed;
        this.siret = siret;
        this.address = address;
        this.enterprise = enterprise;
    }

    public Integer getId() {
        return id;
    }

    public String getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateActivityStarted() {
        return dateActivityStarted;
    }

    public void setDateActivityStarted(String dateActivityStarted) {
        this.dateActivityStarted = dateActivityStarted;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
