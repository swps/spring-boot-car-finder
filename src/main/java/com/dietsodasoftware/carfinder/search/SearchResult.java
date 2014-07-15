package com.dietsodasoftware.carfinder.search;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.infusionsoft.search.api.service.query.QueryResponse;
import com.infusionsoft.search.api.service.query.QueryResult;

import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/15/14
 */
public class SearchResult<T> {
    private final Iterable<T> results;
    private final int resultCount;
    private final int totalCount;

    public SearchResult(Iterable<T> results, int resultCount, int totalCount) {
        this.results = results;
        this.resultCount = resultCount;
        this.totalCount = totalCount;
    }

    public Iterable<T> getResults(){
        return results;
    }

    public int getReturned(){
        return resultCount;
    }

    public int getTotal(){
        return totalCount;
    }

    static List<Long> getIds( QueryResponse response){
        return Lists.transform(response.getQueryResults(), new Function<QueryResult, Long>() {
            @Override
            public Long apply(QueryResult queryResult) {
                return queryResult.getId();
            }
        });
    }
}
