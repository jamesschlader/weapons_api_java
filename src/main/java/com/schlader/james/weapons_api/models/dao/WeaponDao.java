package com.schlader.james.weapons_api.models.dao;

import com.schlader.james.weapons_api.models.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponDao extends JpaRepository<Weapon, Long> {
}
