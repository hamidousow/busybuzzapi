package com.app.busybuzz.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
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

    @Column(name = "addr_zip_code")
    private String zipCode;

    @Column(name = "addr_optional_info")
    private String optionalInfo;

    @OneToOne(mappedBy = "address")
    private Establishment establishment;

    public Address() {
    }

    public Address(String number, String streetName, String city, String zipCode, String optionalInfo, Establishment establishment) {
        this.number = number;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.optionalInfo = optionalInfo;
        this.establishment = establishment;
    }

    public Address(String number, String streetName, String city, String zipCode) {
        this.number = number;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOptionalInfo() {
        return optionalInfo;
    }

    public void setOptionalInfo(String optionalInfo) {
        this.optionalInfo = optionalInfo;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }
}
