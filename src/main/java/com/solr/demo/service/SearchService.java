package com.solr.demo.service;

import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SolrResponseAttributes.Response;

public interface SearchService {
    public SolrResponse searchQuery(String query);
    public Object getSuggestion(String query);

}
