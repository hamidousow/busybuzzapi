package com.app.busybuzz.services;

import com.app.busybuzz.constantes.Roles;
import com.app.busybuzz.models.Address;
import com.app.busybuzz.models.Enterprise;
import com.app.busybuzz.models.Owner;
import com.app.busybuzz.repositories.AddressRepository;
import com.app.busybuzz.repositories.EnterpriseRepository;
import com.app.busybuzz.repositories.OwnerRepository;

import com.app.busybuzz.services.imp.AddressServiceIMP;
import com.app.busybuzz.services.imp.EnterpriseServiceIMP;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EnterpriseServiceTests {

    @Mock
    private EnterpriseRepository enterpriseRepository;

    @InjectMocks
    private EnterpriseServiceIMP enterpriseService;

    @Test
    public void testEnterpriseService_createOneEnterprise_shouldSaveOneEnterprise() {
        Enterprise enterprise = mock(Enterprise.class);

        doAnswer( i -> {
            Enterprise result = i.getArgument(0);
            assertNotNull(result);
            return null;
        }).when(enterpriseRepository).save(enterprise);

        enterpriseService.save(enterprise);

        verify(enterpriseRepository, times(1)).save(enterprise);

    }

    @Test
    public void testEnterpriseService_findOneById_shouldReturnOneEnterprise() {
        Enterprise entreprise = new Enterprise("mockito", 12345, "031234456");

        when(enterpriseRepository.findById(1)).thenReturn(Optional.of(entreprise));

        Enterprise result = enterpriseService.findOneById(1).get();
        assertThat(result).isNotNull();
    }

    @Test
    public void enterpriseService_testUpdateEnterprise_shouldUpdateOneEnterprise() {
        Enterprise enterprise = new Enterprise("mock", 12345, "031234456");

        doAnswer( i -> {
            Enterprise result = i.getArgument(0);
            result.setName("mockito");
            assertEquals("mockito", result.getName());
            return null;
        }).when(enterpriseRepository).save(enterprise);

        enterpriseService.save(enterprise);

        verify(enterpriseRepository, times(1)).save(enterprise);
        assertEquals("mockito", enterprise.getName());
    }

    @Test
    public void enterpriseServce_findAllEnterprises_shouldReturnListOfEnterprises() {
        List<Enterprise> enterprises = mock(List.class);

        when(enterpriseRepository.findAll()).thenReturn(enterprises);

        List<Enterprise> enterpriseList = enterpriseService.findAll();

        assertNotNull(enterpriseList);

    }

    @Test
    public void enterpriseService_testDeleteOne_shouldReturnNull() {
        Enterprise enterprise = mock(Enterprise.class);

        enterpriseService.delete(enterprise);

        assertAll(() -> enterpriseService.delete(enterprise));
    }
}
