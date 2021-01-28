package com.solr.demo.model.SolrResponseAttributes.ResponseHeaderAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Params {
    private String q;

    public Params() {
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    @Override
    public String toString() {
        return "Params{" +
                "q='" + q + '\'' +
                '}';
    }
}
