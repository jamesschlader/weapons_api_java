package com.schlader.james.weapons_api.controllers;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GraphQLController {

    private GraphQL graphQL;

    public GraphQLController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @GetMapping
    public String getBase() {
        return "Welcome to my graphQlServer";
    }

    @PostMapping("/graphql")
    public ExecutionResult query(@RequestBody String query) {
        return graphQL.execute(query);
    }
}
