package com.solr.demo.model.SolrResponseAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solr.demo.model.SolrResponseAttributes.ResponseAttributes.Docs;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private int numFound;
    private int start;
    private Docs[] docs;

    public Response() {
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Docs[] getDocs() {
        return docs;
    }

    public void setDocs(Docs[] docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Response{" +
                "numFound=" + numFound +
                ", start=" + start +
                ", docs=" + Arrays.toString(docs) +
                '}';
    }
}
