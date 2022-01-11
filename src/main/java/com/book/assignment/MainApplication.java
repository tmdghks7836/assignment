package com.book.assignment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;

@EnableJpaAuditing
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}

}
