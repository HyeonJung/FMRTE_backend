package com.hj.fmrtebackend.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
					.paths(PathSelectors.any())
					.build()
				.apiInfo(apiInfo())
				.tags(new Tag("Test","테스트"),
						new Tag("Search","검색"));
	}
	
	private ApiInfo apiInfo() {

		return new ApiInfo(
                "FMRTE REST API"  // Lunchee 대신에 애플리케이션명을 작성 
                , "REST API Document"
                , "1.0.0"
                , "Terms of service"
                , new Contact("윤현중", "http://www.gaeasoft.co.kr", "guswnd1592@gaeasoft.co.kr")
                , ""
                , "");
	}
	
//	@Bean
//	SecurityConfiguration security() {
//		return new SecurityConfiguration(
//				"1500963822273ca8f252",
//				"6aeebe9c482540189fd5a57b77e6b81b",
//				"",
//				"",
//				"Bearer access_token",
//				ApiKeyVehicle.HEADER,
//				"Authorization",
//				","
//				);
//	}
//	
//	private ApiKey apiKey() {
//		return new ApiKey("AUTHORIZATION", "api_key", "header");
//	}
//	
//	private SecurityContext securityContext() {
//	    return SecurityContext.builder()
//	        .securityReferences(defaultAuth())
//	        .forPaths(PathSelectors.regex("/anyPath.*"))
//	        .build();
//	}
//	
//	List<SecurityReference> defaultAuth() {
//	    AuthorizationScope authorizationScope
//	        = new AuthorizationScope("global", "accessEverything");
//	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//	    authorizationScopes[0] = authorizationScope;
//	    return Lists.newArrayList(
//	        new SecurityReference("AUTHORIZATION", authorizationScopes));
//	  }
	


}
