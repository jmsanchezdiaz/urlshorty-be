package com.jmsd.urlshorty.controllers;

import com.jmsd.urlshorty.controllers.dto.ShortenRequestBody;
import com.jmsd.urlshorty.controllers.dto.URLResponseBody;
import com.jmsd.urlshorty.services.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/api/url")
public class URLShortenerController {
    private final URLShortenerService urlService;

    @Autowired
    public URLShortenerController(URLShortenerService urlService){
        this.urlService = urlService;
    }

    //Cache would be good for avoiding? adding duplicates?
    @PostMapping("/shorten")
    public ResponseEntity<URLResponseBody> shortenURL(@RequestBody ShortenRequestBody body) {
        URLResponseBody response = new URLResponseBody(this.urlService.shorten(body.getUrl()));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<URLResponseBody> getURL(@PathVariable String id){
        URLResponseBody response = new URLResponseBody(this.urlService.getURL(id));
        return ResponseEntity.ok().contentType(
                MediaType.APPLICATION_JSON
        ).body(response);
    }

}
