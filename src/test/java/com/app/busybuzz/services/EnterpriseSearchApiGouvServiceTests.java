package com.app.busybuzz.services;

import com.app.busybuzz.dto.searchentrepriseapigouv.EnterpriseApiGouvDTO;
import com.app.busybuzz.dto.searchentrepriseapigouv.ResponseFromEnterpriseSearchApiDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EnterpriseSearchApiGouvServiceTests {

    @Autowired
    IEnterpriseSearchApiGouvService enterpriseSearchApiGouvService;

    @Test
    public void shouldSearchAndReturnOneEnterprise() {
        String enterpriseName = "shaggy barbershop";
        ResponseEntity<ResponseFromEnterpriseSearchApiDTO> response = enterpriseSearchApiGouvService.findEnterpriseByName(enterpriseName);
        assertFalse(response.getBody().getResults().isEmpty());
    }
}
