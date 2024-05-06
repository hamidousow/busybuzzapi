package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_enterprise")
public class Enterprise {

    @Id
    @Column(name = "ent_id")
    @SequenceGenerator(name = "enterprise_id_seq_gen", sequenceName = "enterprise_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_id_seq_gen")
    private Integer id;

    @Column(name = "ent_name")
    private String name;

    @Column(name = "ent_siren")
    private int siren;

    @Column(name = "ent_siret")
    private int siret;

    @Column(name = "ent_vote_score")
    private Integer voteScore;

    @Column(name = "ent_phone_number")
    private String phoneNumber;

    @ManyToOne(targetEntity = Owner.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id")
    private Owner owner;



}
