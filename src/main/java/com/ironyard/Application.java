package com.ironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {
    public static void main(String[] args){ SpringApplication.run(Application.class, args);}


    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Player")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/player.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Tennis Match Tracker API with Swagger, SpringBoot, JPA via Hibernate")
                .description("Place Your Tennis Tournament Bets Here!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Nathaniel Ellsworth")
                .license("Apache License Version 2.1")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }


}