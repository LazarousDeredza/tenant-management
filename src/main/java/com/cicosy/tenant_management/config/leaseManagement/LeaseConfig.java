
package com.cicosy.tenant_management.config.leaseManagement;

import com.cicosy.tenant_management.repository.leaseManagement.LeaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeaseConfig {
    public LeaseConfig() {
    }

    @Bean
    CommandLineRunner commandLineRunner(LeaseRepository repository) {
        return (args) -> {
        };
    }
}