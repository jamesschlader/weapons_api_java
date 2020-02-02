package com.schlader.james.weapons_api.models.dao;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFetcher<T> {
    T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}