package com.demo.authserver.secureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SecureserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureserviceApplication.class, args);
	}

}
