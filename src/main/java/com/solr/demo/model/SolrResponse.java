package com.solr.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.solr.demo.model.SolrResponseAttributes.ResponseHeader;
import com.solr.demo.model.SolrResponseAttributes.Response;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SolrResponse {
    private ResponseHeader responseHeader;
    private Response response;
    private JsonNode highlighting;
    private JsonNode facet_counts;

    public SolrResponse() {
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public JsonNode getHighlighting() {
        return highlighting;
    }

    public void setHighlighting(JsonNode highlighting) {
        this.highlighting = highlighting;
    }

    public JsonNode getFacet_counts() {
        return facet_counts;
    }

    public void setFacet_counts(JsonNode facet_counts) {
        this.facet_counts = facet_counts;
    }

    @Override
    public String toString() {
        return "SolrResponse{" +
                "responseHeader=" + responseHeader +
                ", response=" + response +
                ", highlighting=" + highlighting +
                ", facet_counts=" + facet_counts +
                '}';
    }
}
