package com.app.busybuzz.config;

import com.app.busybuzz.services.imp.AddressServiceIMP;
import com.app.busybuzz.services.imp.OwnerServiceIMP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OwnerServiceIMP ownerService() {
        return new OwnerServiceIMP();
    }

    public AddressServiceIMP addressService() {
        return new AddressServiceIMP();
    }
}
