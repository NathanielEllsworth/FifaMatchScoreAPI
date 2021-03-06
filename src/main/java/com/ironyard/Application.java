package com.ironyard;

import com.ironyard.dto.FifaMatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
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

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        RestTemplate restTemplate = new RestTemplate();
        //FifaMatch match = restTemplate.getForObject("http://worldcup.sfg.io/teams/results", FifaMatch.class);
        //log.info(team.toString());


        //do array of objects
        FifaMatch[] matches = restTemplate.getForObject("http://worldcup.sfg.io/teams/results", FifaMatch[].class);
        log.info(matches.toString());

    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fifaMatch")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/FifaMatches.*"))
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