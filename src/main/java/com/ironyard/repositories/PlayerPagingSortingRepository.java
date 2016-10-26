package com.ironyard.repositories;

import com.ironyard.data.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by nathanielellsworth on 10/26/16.
 */
public interface PlayerPagingSortingRepository extends PagingAndSortingRepository<Player, Long> {
}
