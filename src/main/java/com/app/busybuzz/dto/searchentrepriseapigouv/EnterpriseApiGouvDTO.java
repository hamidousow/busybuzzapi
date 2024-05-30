package com.app.busybuzz.dto.searchentrepriseapigouv;

import com.app.busybuzz.dto.owner.OwnerDto;
import com.app.busybuzz.models.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class EnterpriseApiGouvDTO {

    @JsonProperty("siren")
    public String siren;

    @JsonProperty("nom_complet")
    public String fullName;

    @JsonProperty("nom_raison_social")
    public String socialReasonName;

    @JsonProperty("nombre_etablissements")
    public Integer countEstablishment;

    @JsonProperty("nombre_etablissements_ouverts")
    public Integer countEstablishmentOpened;

    @JsonProperty("siege")
    public Establishment headOffice;

    @JsonProperty("date_creation")
    public String dateCreation;

    @JsonProperty("categorie_entreprise")
    public String enterprisecategory;


    @JsonProperty("dirigeants")
    public List<OwnerDto> owners;

    @JsonProperty("matching_etablissements")
    public List<Establishment> matchingEstablissements;

    public EnterpriseApiGouvDTO() {}


}
