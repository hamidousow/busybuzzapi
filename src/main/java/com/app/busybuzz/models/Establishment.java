package com.app.busybuzz.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name="ent_id")
    private Enterprise enterprise;
}
