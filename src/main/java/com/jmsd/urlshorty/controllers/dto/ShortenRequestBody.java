package com.jmsd.urlshorty.controllers.dto;

public class ShortenRequestBody {
    private String url;

    public ShortenRequestBody(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
