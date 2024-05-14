package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_domain_activity")
public class DomainActivity {

    @Id
    @SequenceGenerator(name = "domain_activity_id_seq_gen", sequenceName = "domain_activity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domain_activity_id_seq_gen")
    @Column(name = "dom_id")
    Integer id;

    @Column(name = "dom_name")
    String name;
}
