package com.leonildo.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonildo.bookstore.service.BDService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private BDService bdService;
	
	@Bean
	public void instanciaBaseDeDados() {
		bdService.instanciaBaseDeDados();
	}
}
