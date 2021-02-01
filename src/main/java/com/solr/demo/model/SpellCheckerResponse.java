package com.solr.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.model.SolrResponseAttributes.ResponseHeader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpellCheckerResponse {
    private ResponseHeader responseHeader;
    private Response response;
    private JsonNode spellcheck;

    public SpellCheckerResponse() {
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

    public JsonNode getSpellcheck() {
        return spellcheck;
    }

    public void setSpellcheck(JsonNode spellcheck) {
        this.spellcheck = spellcheck;
    }
}
