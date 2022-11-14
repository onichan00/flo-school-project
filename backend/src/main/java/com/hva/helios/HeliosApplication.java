package com.hva.helios;

import com.hva.helios.repositories.LanguageRepository;
import com.hva.helios.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HeliosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HeliosApplication.class, args);
		LanguageRepository languageRepository = applicationContext.getBean(LanguageRepository.class);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
	}

}
