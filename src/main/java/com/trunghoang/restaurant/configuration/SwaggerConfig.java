package com.trunghoang.restaurant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	private static final String TITLE = "Restaurant application";
	private static final String DESCRIPTION = "Support CRUD to manage the restaurant";
	private static final String VERSION = "VERSION";
	private static final String LICENSE = "LICENSE";

	private static final String URL_PATTERN = "/v1/.*";

	// @formatter:off
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				// look up urls in  "/v1/*"
				.paths(PathSelectors.regex(URL_PATTERN))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(VERSION)
				.termsOfServiceUrl("http://terms-of-services.url")
				.license(LICENSE)
				.licenseUrl("http://url-to-license.com")
				.build();
	}
	// @formatter:on

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Enable swagger-ui for visual documentation
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}