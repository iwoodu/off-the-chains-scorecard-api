package com.rhitm.scorecard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.rhitm.scorecard.controller"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(buildApiInfo());
    }

	private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Off the Chains Scorecard REST API")
                .description("\"REST API for Off the Chains Scorecards\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("iwoodu", "https://github.com/iwoodu/off-the-chains-scorecard-api", "david.wood@tutanota.com"))
                .build();
	}
}