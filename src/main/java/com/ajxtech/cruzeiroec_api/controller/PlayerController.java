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

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        return playerRepository.findById(id).map(player -> {
            player.setName(updatedPlayer.getName());
            player.setAge(updatedPlayer.getAge());
            player.setHeight(updatedPlayer.getHeight());
            player.setWeight(updatedPlayer.getWeight());
            player.setRole(updatedPlayer.getRole());
            return playerRepository.save(player);
        }).orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
    }
}