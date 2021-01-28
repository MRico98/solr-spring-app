package com.solr.demo.model.SolrResponseAttributes.ResponseAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Docs {
    private String[] tstamp;
    private String[] digest;
    private String[] host;
    private String[] description;
    private double[] boost;
    private int id;
    private String[] title;
    private String[] url;
    private String[] content;
    private String[] host_str;
    private String[] url_str;
    private String[] title_str;
    private long _version_;
    private String[] description_str;
    private String[] content_str;
    private String[] digest_str;

    public Docs() {
    }

    public String[] getTstamp() {
        return tstamp;
    }

    public void setTstamp(String[] tstamp) {
        this.tstamp = tstamp;
    }

    public String[] getDigest() {
        return digest;
    }

    public void setDigest(String[] digest) {
        this.digest = digest;
    }

    public String[] getHost() {
        return host;
    }

    public void setHost(String[] host) {
        this.host = host;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public double[] getBoost() {
        return boost;
    }

    public void setBoost(double[] boost) {
        this.boost = boost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String[] getUrl() {
        return url;
    }

    public void setUrl(String[] url) {
        this.url = url;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public String[] getHost_str() {
        return host_str;
    }

    public void setHost_str(String[] host_str) {
        this.host_str = host_str;
    }

    public String[] getUrl_str() {
        return url_str;
    }

    public void setUrl_str(String[] url_str) {
        this.url_str = url_str;
    }

    public String[] getTitle_str() {
        return title_str;
    }

    public void setTitle_str(String[] title_str) {
        this.title_str = title_str;
    }

    public long get_version_() {
        return _version_;
    }

    public void set_version_(long _version_) {
        this._version_ = _version_;
    }

    public String[] getDescription_str() {
        return description_str;
    }

    public void setDescription_str(String[] description_str) {
        this.description_str = description_str;
    }

    public String[] getContent_str() {
        return content_str;
    }

    public void setContent_str(String[] content_str) {
        this.content_str = content_str;
    }

    public String[] getDigest_str() {
        return digest_str;
    }

    public void setDigest_str(String[] digest_str) {
        this.digest_str = digest_str;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "tstamp=" + Arrays.toString(tstamp) +
                ", digest=" + Arrays.toString(digest) +
                ", host=" + Arrays.toString(host) +
                ", description=" + Arrays.toString(description) +
                ", boost=" + Arrays.toString(boost) +
                ", id=" + id +
                ", title=" + Arrays.toString(title) +
                ", url=" + Arrays.toString(url) +
                ", content=" + Arrays.toString(content) +
                ", host_str=" + Arrays.toString(host_str) +
                ", url_str=" + Arrays.toString(url_str) +
                ", title_str=" + Arrays.toString(title_str) +
                ", _version_=" + _version_ +
                ", description_str=" + Arrays.toString(description_str) +
                ", content_str=" + Arrays.toString(content_str) +
                ", digest_str=" + Arrays.toString(digest_str) +
                '}';
    }
}
