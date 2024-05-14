package com.app.busybuzz.services;

import com.app.busybuzz.dto.searchentrepriseapigouv.EnterpriseApiGouvDTO;
import com.app.busybuzz.dto.searchentrepriseapigouv.ResponseFromEnterpriseSearchApiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEnterpriseSearchApiGouvService {

    ResponseEntity<ResponseFromEnterpriseSearchApiDTO> findEnterpriseByName(String name);
}
