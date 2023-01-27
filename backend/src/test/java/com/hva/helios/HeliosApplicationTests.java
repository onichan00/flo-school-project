package com.hva.helios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeliosApplicationTests {
	@Autowired
	HeliosApplication application = null;

	@Test
	void contextLoads() {
		assertNotNull(application);
		System.out.println("Application auto-configuration has succeeded.");
	}
}
