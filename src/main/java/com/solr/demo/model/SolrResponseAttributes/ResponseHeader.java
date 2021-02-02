package com.solr.demo.model.SolrResponseAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solr.demo.model.SolrResponseAttributes.ResponseHeaderAttributes.Params;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {
    private int status;
    private int qTime;
    private Params params;

    public ResponseHeader() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getqTime() {
        return qTime;
    }

    public void setqTime(int qTime) {
        this.qTime = qTime;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "status=" + status +
                ", qTime=" + qTime +
                ", params=" + params +
                '}';
    }
}