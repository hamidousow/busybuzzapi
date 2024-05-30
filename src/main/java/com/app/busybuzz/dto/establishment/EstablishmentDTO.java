package com.app.busybuzz.dto.establishment;

import com.app.busybuzz.models.Enterprise;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EstablishmentDTO {
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

    //@JsonProperty("libelle_commune")
    private String latitude;

    //@JsonProperty("libelle_commune")
    private String longitude;

    @JsonProperty("siret")
    private String siret;


    private Enterprise enterprise;
}
