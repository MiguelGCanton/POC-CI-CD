package com.pizzacli.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
@SpringBootTest
class ClientApplicationTests {

	@Test
	void contextLoads() {
		String message = "joke test";
		Assert.assertNotNull(message);
	}



}
