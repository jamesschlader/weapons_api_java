package com.schlader.james.weapons_api.services;

import com.schlader.james.weapons_api.models.dao.WeaponDao;
import com.schlader.james.weapons_api.models.entities.Weapon;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private WeaponDao weaponDao;

    public GraphQLDataFetchers(WeaponDao weaponDao) {
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
            Map<String, Object> id = dataFetchingEnvironment.getArguments();
            Long requestId = Long.parseLong(id.get("id").toString());
            return weaponDao.findById(requestId);
        };
    }
}
