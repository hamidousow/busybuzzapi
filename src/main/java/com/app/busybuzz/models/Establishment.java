package com.app.busybuzz.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Establishment {

    @JsonProperty("adresse")
    private String address;

    @JsonProperty("activite_principale")
    private String mainActivity;

    @JsonProperty("code_postal")
    private String zipCode;

    @JsonProperty("date_creation")
    private String dateCreated;

    @JsonProperty("date_debut_activite")
    private String dateActivityStarted;

    @JsonProperty("date_fermeture")
    private String dateClosed;

    @JsonProperty("libelle_commune")
    private String city;

    private String latitude;

    private String longitude;

    private String siret;
}
