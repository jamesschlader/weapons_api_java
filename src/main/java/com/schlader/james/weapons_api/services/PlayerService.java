package com.schlader.james.weapons_api.services;

import com.schlader.james.weapons_api.models.dao.PlayerDAO;
import com.schlader.james.weapons_api.models.entities.Player;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlayerService {

    private PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    DataFetcher getAllPlayers() {
        return dataFetchingEnvironment -> {
            final List<Player> all = playerDAO.findAll();
            return all;
        };
    }

    DataFetcher getPlayerById() {
        return dataFetchingEnvironment -> {
            Map<String, Object> requestId = dataFetchingEnvironment.getArguments();
            Long id = Long.parseLong(requestId.get("id").toString());
            return playerDAO.findById(id);
        };
    }

    DataFetcher getPlayerByEmail() {
        return dataFetchingEnvironment -> {
            Map<String, Object> requestEmail = dataFetchingEnvironment.getArguments();
            String email = String.valueOf(requestEmail.get("email"));
            return playerDAO.findDistinctByEmail(email);
        };
    }

}
