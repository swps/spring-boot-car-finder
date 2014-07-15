package com.dietsodasoftware.carfinder.mvc.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collections;
import java.util.List;

/**
 * User: wendel.schultz
 * Date: 7/14/14
 */
public class ListResults<T> {

    public ListResults(List<T> results){
        this(results == null ? (List<T>) Collections.emptyList() : results,
             results == null ? 0 : results.size(),
             1);
    }

    public ListResults(List<T> results, int count, int page){
        this.results = results;
        this.count = count;
        this.page = page;
    }

    @JsonProperty
    private List<T> results;

    @JsonProperty
    private int count;

    @JsonProperty
    private int page;


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("count", count)
                .append("page", page)
                .append("results", results)
                .toString();
    }
}
