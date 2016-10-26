package com.ironyard.repositories;

import com.ironyard.data.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
