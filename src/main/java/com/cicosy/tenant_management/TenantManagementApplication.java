package com.cicosy.tenant_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TenantManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantManagementApplication.class, args);
	}

}
