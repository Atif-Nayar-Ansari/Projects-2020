package com.nt.swagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// .groupName("public-api")
				.groupName("Atif-GROUP")
				.apiInfo(apiInfo())// we can write a method and provide here
				.select()
				//.paths(postPaths())//wew also can select the path from where it is going to take the and prepare documentation
				.build();
	}
/*
	private Predicate<String> postPaths() {
		return regex("/");
	}
*/
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Atif Nayar API")
				.description("Atif API reference for developers..")
				.termsOfServiceUrl("http://atif.com")
				.contact("unknown@gmail.com")
				.license("Nop License till now")
				.licenseUrl("Unknown2@hotmail.com")
				.version("1.0")
				.build();
	}
	 	

}