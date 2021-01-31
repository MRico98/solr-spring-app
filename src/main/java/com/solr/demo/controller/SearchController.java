package com.solr.demo.controller;

import com.solr.demo.model.SolrResponse;
import com.solr.demo.model.SolrResponseAttributes.Response;
import com.solr.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<SolrResponse> search(@RequestParam(required = false) String query){
        return ResponseEntity.ok().body(searchService.searchQuery(query));
    }

    @CrossOrigin
    @GetMapping("/suggestion")
    public ResponseEntity<Object> suggestion(@RequestParam(required = false) String query){
        return ResponseEntity.ok().body(searchService.getSuggestion(query));
    }

}
