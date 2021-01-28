package com.solr.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.model.SolrResponseAttributes.ResponseHeader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SolrResponse {
    private ResponseHeader responseHeader;
    private Response response;

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

    @Override
    public String toString() {
        return "SolrResponse{" +
                "responseHeader=" + responseHeader +
                ", response=" + response +
                '}';
    }
}
