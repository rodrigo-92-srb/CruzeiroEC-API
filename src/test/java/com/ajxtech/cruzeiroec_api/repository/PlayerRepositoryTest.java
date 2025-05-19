package com.ajxtech.cruzeiroec_api.repository;

import com.ajxtech.cruzeiroec_api.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testSavePlayer() {
        Player player = new Player();
        player.setName("John Doe");
        player.setAge(25);
        player.setHeight(1.80);
        player.setWeight(75.0);
        player.setRole("Forward");

        Player savedPlayer = playerRepository.save(player);
        assertThat(savedPlayer.getId()).isNotNull();
    }

    @Test
    public void testFindById() {
        Player player = new Player();
        player.setName("Jack Doe");
        player.setAge(22);
        player.setHeight(1.90);
        player.setWeight(80.0);
        player.setRole("Defender");

        Player savedPlayer = playerRepository.save(player);
        Optional<Player> foundPlayer = playerRepository.findById(savedPlayer.getId());
        assertThat(foundPlayer).isPresent();
        assertThat(foundPlayer.get().getName()).isEqualTo("Jack Doe");

    }
}