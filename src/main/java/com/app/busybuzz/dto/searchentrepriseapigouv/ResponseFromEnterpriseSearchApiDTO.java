package com.app.busybuzz.dto.searchentrepriseapigouv;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseFromEnterpriseSearchApiDTO {

    private List<EnterpriseApiGouvDTO> results;

    @JsonProperty("total_results")
    private Integer totalResults;

    @JsonProperty("page")
    private Integer currentPage;

    @JsonProperty("per_page")
    private Integer resultPerPage;

    @JsonProperty("total_pages")
    private Integer totalPages;

    public ResponseFromEnterpriseSearchApiDTO() {}


}
