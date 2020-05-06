package com.schlader.james.weapons_api.models.dao;

import com.schlader.james.weapons_api.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerDAO extends JpaRepository<Player, Long> {
    Player findDistinctByEmail(String email);
}
