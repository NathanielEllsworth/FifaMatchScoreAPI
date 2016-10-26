package com.ironyard.controller;

import com.ironyard.dto.FifaMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
@RestController
public class FifaMatchController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/FifaMatches", method = RequestMethod.GET)
    public Iterable<FifaMatch> list(@RequestParam(value = "filter", required = false) String filter) {
        log.debug("Request to list matches played.");
        RestTemplate restTemplate = new RestTemplate();
        FifaMatch[] matches = restTemplate.getForObject("http://worldcup.sfg.io/teams/results", FifaMatch[].class);
        log.info(matches.toString());
        log.debug("Fetch score complete.");
        List<FifaMatch> foundAllList = Arrays.asList(matches);
        List<FifaMatch> filteredList = new ArrayList<>();


        // only return matches that start with parameter name
        if (filter != null) {
            // filter the list
            for (FifaMatch aMatch : foundAllList) {
                if (aMatch.getCountry().startsWith(filter)) {
                    filteredList.add(aMatch);
                }
            }
        } else {
            // just return all
            filteredList = foundAllList;
        }
        return filteredList;

    }
}

