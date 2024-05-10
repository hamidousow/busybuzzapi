package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Setter
@Getter
@Data
@Table(name = "t_address")
public class Address {

    @Id
    @SequenceGenerator(name = "addr_id_seq_gen", sequenceName = "address_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addr_id_seq_gen")
    @Column(name = "addr_id")
    private Integer id;

    @Column(name = "addr_number")
    private String number;

    @Column(name = "addr_street_name")
    private String streetName;
    @Column(name = "addr_city")
    private String city;
    @Column(name = "addr_postal_code")
    private String postalCode;
    @Column(name = "addr_optional_info")
    private String optionalInfo;

    @ManyToOne(targetEntity = Enterprise.class)
    @JoinColumn(name = "ent_id")
    private Enterprise enterprise;


}