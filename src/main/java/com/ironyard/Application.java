package com.ironyard;

import com.ironyard.data.FifaMatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
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
        RestTemplate restTemplate = new RestTemplate();
        //FifaMatch match = restTemplate.getForObject("http://worldcup.sfg.io/teams/results", FifaMatch.class);
        //log.info(team.toString());


        //do array of objects
        FifaMatch[] matches = restTemplate.getForObject("http://worldcup.sfg.io/teams/results", FifaMatch[].class);
        log.info(matches.toString());

    }

}