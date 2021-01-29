package com.solr.demo.service;

import com.solr.demo.model.SolrResponseAttributes.Response;

public interface SearchService {
    public Response searchQuery(String query);
}
