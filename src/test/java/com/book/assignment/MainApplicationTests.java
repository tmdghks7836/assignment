package com.book.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MainApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void contextLoads() {

		System.out.println(bCryptPasswordEncoder.encode("vkfl4521687!"));
	}

}
