package com.schlader.james.weapons_api.services;

import com.schlader.james.weapons_api.models.dao.WeaponDao;
import com.schlader.james.weapons_api.models.entities.Weapon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private WeaponDao weaponDao;

    public WeaponService(WeaponDao weaponDao) {
        this.weaponDao = weaponDao;
    }

    public List<Weapon> getAllWeapons() {
        return weaponDao.findAll();
    }
}
