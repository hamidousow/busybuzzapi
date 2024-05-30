package com.app.busybuzz.dto.owner;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OwnerDto {

    @JsonProperty("nom")
    private String name;

    @JsonProperty("prenoms")
    private String lastName;

    @JsonProperty("qualite")
    private String role;

}
