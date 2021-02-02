package com.solr.demo.config;

public class SolrRestConfig {
    public static final String solrUrl = "http://localhost:8983/solr";
    public static final String solrCore = "/mycore/";
    public static final String query = "*:*";
    public static final String start = "0";
    public static final String selectAction = "select";
    public static final String suggestAction = "suggest";
    public static final String highlightingField = "content";
    public static final String spellCheckerAction = "spell";
    public static final String facetingDefaultField = "host";
}
