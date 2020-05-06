package com.schlader.james.weapons_api.services;

import com.schlader.james.weapons_api.models.dao.GameCharacterDAO;
import com.schlader.james.weapons_api.models.entities.GameCharacter;
import com.schlader.james.weapons_api.models.entities.Player;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GameCharacterService {

    private GameCharacterDAO gameCharacterDAO;

    public GameCharacterService(GameCharacterDAO gameCharacterDAO) {
        this.gameCharacterDAO = gameCharacterDAO;
    }


    DataFetcher getAllCharacters() {
        return dataFetchingEnvironment -> {
            final List<GameCharacter> all = gameCharacterDAO.findAll();
            return all;
        };
    }

    DataFetcher getCharacterById() {
        return dataFetchingEnvironment -> {
            Map<String, Object> requestId = dataFetchingEnvironment.getArguments();
            Long id = Long.parseLong(requestId.get("id").toString());
            return gameCharacterDAO.findById(id);
        };
    }

    DataFetcher getCharacterByName() {
        return dataFetchingEnvironment -> {
            Map<String, Object> requestName = dataFetchingEnvironment.getArguments();
            String name = String.valueOf(requestName.get("name"));
            return gameCharacterDAO.findByName(name);
        };
    }

    DataFetcher getCharactersByPlayerId() {
        return dataFetchingEnvironment -> {
            Player player = dataFetchingEnvironment.getSource();
            Long id = player.getPlayerId();
            return gameCharacterDAO.findAllByPlayer_PlayerId(id);
        };
    }


}
