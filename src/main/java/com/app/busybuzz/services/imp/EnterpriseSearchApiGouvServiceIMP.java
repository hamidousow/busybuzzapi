package com.app.busybuzz.services.imp;

import com.app.busybuzz.dto.searchentrepriseapigouv.ResponseFromEnterpriseSearchApiDTO;
import com.app.busybuzz.services.IEnterpriseSearchApiGouvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class EnterpriseSearchApiGouvServiceIMP implements IEnterpriseSearchApiGouvService {

    @Autowired
    Environment environment;

    private String url = "https://recherche-entreprises.api.gouv.fr/search?";

    @Override
    public ResponseEntity<ResponseFromEnterpriseSearchApiDTO> findEnterpriseByName(String name) {

        RestClient defaultClient = RestClient.create();

        ResponseEntity<ResponseFromEnterpriseSearchApiDTO> responseEntity = defaultClient.get()
                .uri("https://recherche-entreprises.api.gouv.fr/search?q={name}", name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(ResponseFromEnterpriseSearchApiDTO.class);

        return responseEntity;

    }
}
