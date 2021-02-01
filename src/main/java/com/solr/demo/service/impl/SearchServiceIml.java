package com.solr.demo.service.impl;

import com.solr.demo.config.SolrRestConfig;
import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SpellCheckerResponse;
import com.solr.demo.model.SuggesterResponse;
import com.solr.demo.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceIml implements SearchService {

    private String solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public SolrResponse searchQuery(String query) {
        SolrResponse response = restTemplate.getForObject(urlSelectCreation(query) ,SolrResponse.class);
        solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;
        return response;
    }

    @Override
    public SuggesterResponse getSuggestion(String query) {
        SuggesterResponse response = restTemplate.getForObject(urlSuggestCreation(query),SuggesterResponse.class);
        solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;
        return response;
    }

    @Override
    public SpellCheckerResponse getSpellCorrection(String query) {
        SpellCheckerResponse response = restTemplate.getForObject(urlSpellCheckerCreation(query),SpellCheckerResponse.class);
        solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;
        return response;
    }

    private String urlSelectCreation(String query){
        if(query == null) {
            solrUrl += SolrRestConfig.selectAction + "?q=" + SolrRestConfig.query + "&hl=on&hl.fl=" + SolrRestConfig.highlightingField ;
        }
        else{
            solrUrl += SolrRestConfig.selectAction + "?q=" + query + "&hl=on&hl.fl=" + SolrRestConfig.highlightingField ;
        }
        System.out.println(solrUrl);
        return solrUrl;
    }

    private String urlSuggestCreation(String query){
        solrUrl += SolrRestConfig.suggestAction + "?suggest=true&suggest.build=true&suggest.dictionary=mySuggester&suggest.q=" + query;
        return solrUrl;
    }

    private String urlSpellCheckerCreation(String query){
        solrUrl += SolrRestConfig.spellCheckerAction + "?spellcheck=on&spellcheck.q=" + query;
        return solrUrl;
    }

    public String getSolrUrl() {
        return solrUrl;
    }

    public void setSolrUrl(String solrUrl) {
        this.solrUrl = solrUrl;
    }
}
