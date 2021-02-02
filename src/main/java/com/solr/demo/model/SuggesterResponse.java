package com.solr.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.solr.demo.model.SolrResponseAttributes.ResponseHeader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggesterResponse {
    private ResponseHeader responseHeader;
    private String command;
    private JsonNode suggest;

    public SuggesterResponse() {
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public JsonNode getSuggest() {
        return suggest;
    }

    public void setSuggest(JsonNode suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "SuggesterResponse{" +
                "responseHeader=" + responseHeader +
                ", command='" + command + '\'' +
                ", suggest=" + suggest +
                '}';
    }
}
