package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
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
    @ManyToOne(targetEntity = Enterprise.class, fetch = FetchType.EAGER)
    Enterprise enterprise;

    @JoinColumn(name = "per_id")
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    Person person;

    public Comment() {
    }

    public Comment(Date creationDate, String text, Enterprise enterprise, Person person) {
        this.creationDate = creationDate;
        this.text = text;
        this.enterprise = enterprise;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
