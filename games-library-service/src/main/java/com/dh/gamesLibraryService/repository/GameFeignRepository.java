package com.dh.gamesLibraryService.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dh.gamesLibraryService.model.dto.GameWS;

@FeignClient(name="games-service")
public interface GameFeignRepository {
    @GetMapping("/games/{gameId}")
    GameWS getGameDetails(@PathVariable Integer gameId);

}
