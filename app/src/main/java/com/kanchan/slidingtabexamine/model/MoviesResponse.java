package com.kanchan.slidingtabexamine.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kanchan on 12/25/2016.
 */

public class MoviesResponse implements Serializable {

    private int page;
    private List<Movie> results;
    private int totalResults;
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
