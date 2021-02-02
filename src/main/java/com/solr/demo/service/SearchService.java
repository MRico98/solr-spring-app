package com.solr.demo.service;

import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.model.SpellCheckerResponse;
import com.solr.demo.model.SuggesterResponse;

public interface SearchService {
    public SolrResponse searchQuery(String query,String start);
    public SuggesterResponse getSuggestion(String query);
    public SpellCheckerResponse getSpellCorrection(String query);
}
