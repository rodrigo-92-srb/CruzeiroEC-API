package com.ajxtech.cruzeiroec_api.repository;

import com.ajxtech.cruzeiroec_api.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByNameContainingIgnoreCase(String name);
}
