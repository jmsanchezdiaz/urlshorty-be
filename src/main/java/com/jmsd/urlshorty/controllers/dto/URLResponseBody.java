package com.jmsd.urlshorty.controllers.dto;

public class URLResponseBody {
    private String data;

    public URLResponseBody(String data) {
        this.data = data;
    }

    public String getData() {return this.data; };
}
