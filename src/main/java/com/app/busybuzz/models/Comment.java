package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_comment")
public class Comment {

    @Id
    @SequenceGenerator(name = "comm_id_seq_gen", sequenceName = "comment_id_seq", allocationSize = 3, initialValue = 19)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comm_id_seq_gen")
    @Column(name = "com_id")
    private Integer id;

    @Column(name = "com_date")
    Date creationDate;

    @Column(name = "com_text")
    String text;

    @JoinColumn(name = "ent_id")
    @ManyToOne(targetEntity = Enterprise.class)
    Enterprise enterprise;

    @JoinColumn(name = "per_id")
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    Person person;

}
