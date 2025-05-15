package com.ajxtech.cruzeiroec_api.controller;

import com.ajxtech.cruzeiroec_api.model.Player;
import com.ajxtech.cruzeiroec_api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/{id}")
    public Player createPlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerRepository.save(player);
    }
}