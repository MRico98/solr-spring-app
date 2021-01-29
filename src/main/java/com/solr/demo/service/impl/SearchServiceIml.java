package com.solr.demo.service.impl;

import com.solr.demo.config.SolrRestConfig;
import com.solr.demo.controller.SearchController;
import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceIml implements SearchService {

    private String solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Response searchQuery(String query) {
        SolrResponse response = restTemplate.getForObject(urlSelectCreation(query),SolrResponse.class);
        solrUrl = SolrRestConfig.solrUrl + SolrRestConfig.solrCore;
        return response.getResponse();
    }

    private String urlSelectCreation(String query){
        if(query == null) {
            solrUrl += "select?q=" + SolrRestConfig.query;
        }
        else{
            solrUrl += "select?q=" + query;
        }
        System.out.println(solrUrl);
        return solrUrl;
    }

    public String getSolrUrl() {
        return solrUrl;
    }

    public void setSolrUrl(String solrUrl) {
        this.solrUrl = solrUrl;
    }
}
