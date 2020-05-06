package com.schlader.james.weapons_api.models.dao;

import com.schlader.james.weapons_api.models.entities.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCharacterDAO extends JpaRepository<GameCharacter, Long> {
    GameCharacter findByName(String name);

    List<GameCharacter> findAllByPlayer_PlayerId(Long id);
}
