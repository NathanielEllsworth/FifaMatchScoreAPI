package com.ironyard.controller;

import com.ironyard.data.Player;
import com.ironyard.repositories.PlayerPagingSortingRepository;
import com.ironyard.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
@RestController
public class PlayerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private PlayerRepository playerRepo;
    private PlayerPagingSortingRepository playerPgStRepo;

    @Autowired
    public void setPlayerPgStRepo(PlayerPagingSortingRepository playerPgStRepo){this.playerPgStRepo = playerPgStRepo;}

    @Autowired
    public void setPlayerRepo(PlayerRepository playerRepo){this.playerRepo = playerRepo;}

    @RequestMapping(value = "/player", method = RequestMethod.POST, produces = "application/json")
    public Player save(@RequestBody Player aPlayer){
        playerRepo.save(aPlayer);
        return playerRepo.findOne(aPlayer.getId());
    }

    @RequestMapping(value = "/player/update", method = RequestMethod.GET)
    public Player update(@RequestBody Player aPlayer){
        playerRepo.save(aPlayer);
        return playerRepo.findOne(aPlayer.getId());
    }

    @RequestMapping(value = "/player/delete/{id}", method = RequestMethod.DELETE)
    public Player delete(@PathVariable long id){
        Player deleted = playerRepo.findOne(id);
        playerRepo.delete(id);
        return deleted;
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public Player show(@PathVariable Long id){
        return playerRepo.findOne(id);
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public Iterable<Player> list(@RequestParam(value = "page") Integer page,
                                 @RequestParam("size") Integer size,
                                 @RequestParam(value = "sortby", required = false) String sortby,
                                 @RequestParam(value = "dir", required = false) Sort.Direction direction){

        Iterable<Player> found = null;

        if(sortby == null){
            sortby = "lastName";
        }

        if(direction == null){
            direction = Sort.Direction.ASC;
        }
        // long way
        Sort s = new Sort(direction, sortby);
        PageRequest pr = new PageRequest(page, size, s);
        found = playerPgStRepo.findAll(pr);


        // Short cut
        //found = playerPgStRepo.findAll(new PageRequest(page, size, new Sort(direction, sortby)));

        return found;


    }






}

