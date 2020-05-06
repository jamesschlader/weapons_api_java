package com.schlader.james.weapons_api.services;

import com.schlader.james.weapons_api.models.dao.WeaponDao;
import com.schlader.james.weapons_api.models.entities.GameCharacter;
import com.schlader.james.weapons_api.models.entities.Weapon;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeaponService {

    private WeaponDao weaponDao;

    public WeaponService(WeaponDao weaponDao) {
        this.weaponDao = weaponDao;
    }

    DataFetcher getAllWeapons() {
        return dataFetchingEnvironment -> {
            final List<Weapon> all = weaponDao.findAll();
            return all;
        };
    }

    DataFetcher getWeaponById() {
        return dataFetchingEnvironment -> {
            Map<String, Object> requestId = dataFetchingEnvironment.getArguments();
            Long id = Long.parseLong(requestId.get("id").toString());
            return weaponDao.findById(id);
        };
    }

    DataFetcher getWeaponsByCharacterId() {
        return dataFetchingEnvironment -> {
            GameCharacter character = dataFetchingEnvironment.getSource();
            return weaponDao.findAll()
                    .stream()
                    .filter(wpn -> character.getWeapons().contains(wpn)).collect(Collectors.toList());
        };
    }

}
