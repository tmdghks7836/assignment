package com.book.assignment.config.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_NAME = "Books API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "Books API 명세서";

    @Bean
    public Docket api() {

        TypeResolver typeResolver = new TypeResolver();

        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(
                        AlternateTypeRules.newRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(SwaggerPage.class))
                )
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.book.assignment"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
	return new ApiInfoBuilder()
		.title(API_NAME)
		.version(API_VERSION)
		.description(API_DESCRIPTION)
		.build();
    }
}