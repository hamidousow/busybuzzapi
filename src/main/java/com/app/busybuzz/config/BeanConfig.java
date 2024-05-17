package com.app.busybuzz.config;

import com.app.busybuzz.repositories.AddressRepository;
import com.app.busybuzz.repositories.EnterpriseRepository;
import com.app.busybuzz.repositories.OwnerRepository;
import com.app.busybuzz.services.imp.AddressServiceIMP;
import com.app.busybuzz.services.imp.EnterpriseServiceIMP;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OwnerServiceIMP ownerService(OwnerRepository ownerRepository) {
        return new OwnerServiceIMP(ownerRepository);
    }

    @Bean
    public AddressServiceIMP addressService(AddressRepository addressRepository) {
        return new AddressServiceIMP(addressRepository);
    }

    @Bean
    public EnterpriseServiceIMP enterpriseService(EnterpriseRepository enterpriseRepository) {
        return new EnterpriseServiceIMP(enterpriseRepository);
    }
}
