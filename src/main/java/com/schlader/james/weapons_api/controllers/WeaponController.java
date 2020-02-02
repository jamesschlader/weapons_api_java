package com.schlader.james.weapons_api.controllers;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weapon")
public class WeaponController {

    private GraphQL graphQL;

    public WeaponController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @PostMapping
    public ExecutionResult getAllWeapons(@RequestBody String query) {
        return graphQL.execute(query);
    }
}
