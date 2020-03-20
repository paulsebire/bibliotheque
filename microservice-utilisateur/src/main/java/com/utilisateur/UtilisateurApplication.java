package com.utilisateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients("com.utilisateur")
@SpringBootApplication
public class UtilisateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilisateurApplication.class, args);
	}

}
