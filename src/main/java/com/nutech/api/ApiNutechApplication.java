package com.nutech.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title="API Contract SIMS PPOB",
				description="<h3>Documentation for Take Home Test API</h3>",
				version = "1.0.0")
)
@SpringBootApplication
public class ApiNutechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNutechApplication.class, args);
	}

}
