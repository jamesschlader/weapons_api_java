package com.schlader.james.weapons_api.services;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    private GameCharacterService gameCharacterService;
    private PlayerService playerService;
    private WeaponService weaponService;

    public GraphQLProvider(GameCharacterService gameCharacterService, PlayerService playerService, WeaponService weaponService) {
        this.gameCharacterService = gameCharacterService;
        this.playerService = playerService;
        this.weaponService = weaponService;
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        File schemaFolder = new File(String.valueOf(new ClassPathResource("schema").getFile()));
        List<File> files = Arrays.asList(Objects.requireNonNull(schemaFolder.listFiles()));
        GraphQLSchema graphQLSchema = buildSchema(files);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(List<File> files) {
        TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        SchemaParser schemaParser = new SchemaParser();

        files.forEach(file -> typeRegistry.merge(schemaParser.parse(file)));

        RuntimeWiring runtimeWiring = buildWiring();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        final String query = "Query";
        final String mutation = "Mutation";
        return RuntimeWiring.newRuntimeWiring()
                .type(query, wiring -> wiring
                        .dataFetcher("getAllWeapons", weaponService.getAllWeapons())
                        .dataFetcher("getAllPlayers", playerService.getAllPlayers())
                        .dataFetcher("getWeaponById", weaponService.getWeaponById())
                        .dataFetcher("getPlayerById", playerService.getPlayerById())
                        .dataFetcher("getPlayerByEmail", playerService.getPlayerByEmail())
                        .dataFetcher("getAllCharacters", gameCharacterService.getAllCharacters())
                        .dataFetcher("getCharacterById", gameCharacterService.getCharacterById())
                        .dataFetcher("getCharacterByName", gameCharacterService.getCharacterByName()))
                .type(newTypeWiring("Player")
                        .dataFetcher("characters", gameCharacterService.getCharactersByPlayerId()))
                .type(newTypeWiring("GameCharacter")
                        .dataFetcher("weapons", weaponService.getWeaponsByCharacterId()))
                .build();
    }
}
