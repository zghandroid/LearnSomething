package com.example.zhang.learnsomething.model;

import java.util.List;

/**
 * Created by 12345 on 2018/3/29.
 */

public class Resulet<T> {


    /**
     * error : false
     */

    private boolean error;
    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public static class ResultsBean {
    }
}
