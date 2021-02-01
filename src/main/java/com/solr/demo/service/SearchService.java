package com.solr.demo.service;

import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.model.SpellCheckerResponse;

public interface SearchService {
    public SolrResponse searchQuery(String query);
    public Object getSuggestion(String query);
    public SpellCheckerResponse getSpellCorrection(String query);
}
