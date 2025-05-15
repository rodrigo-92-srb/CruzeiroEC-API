package com.ajxtech.cruzeiroec_api.repository;

import com.ajxtech.cruzeiroec_api.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
