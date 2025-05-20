package com.ajxtech.cruzeiroec_api.controller;

import com.ajxtech.cruzeiroec_api.model.Player;
import com.ajxtech.cruzeiroec_api.repository.PlayerRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Operation(summary = "Get all players", description = "Returns a list of players")
    @GetMapping
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Operation(summary = "Get player by ID", description = "Returns player by ID")
    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
    }

    @Operation(summary = "Create a new player", description = "Create a player")
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @Operation(summary = "Update player by ID", description = "Update player by ID")
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @Valid @RequestBody Player updatedPlayer) {
        return playerRepository.findById(id).map(player -> {
            player.setName(updatedPlayer.getName());
            player.setAge(updatedPlayer.getAge());
            player.setHeight(updatedPlayer.getHeight());
            player.setWeight(updatedPlayer.getWeight());
            player.setRole(updatedPlayer.getRole());
            return playerRepository.save(player);
        }).orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
    }

    @Operation(summary = "Delete player by ID", description = "Delete player by ID")
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
        return "Player with ID " + id + " was deleted successfully.";
    }

    @GetMapping("/search")
    public List<Player> searchPlayersByName(@RequestParam String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "API is up and running!";
    }
}