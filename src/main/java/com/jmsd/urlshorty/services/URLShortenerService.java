package com.jmsd.urlshorty.services;

import com.google.common.hash.Hashing;
import com.jmsd.urlshorty.repositories.RedisRepository;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class URLShortenerService {
    private final RedisRepository repository;
    private final Hashids hashGen;

    public URLShortenerService(RedisRepository repository) {
        this.repository = repository;
        this.hashGen = new Hashids("base-keys", 6);
    }

    public String shorten(String url) {
        String urlKey = this.genId(url);
        this.repository.put(urlKey, url);

        return urlKey;
    }

    public String getURL(String id) {
        return this.repository.get(id);
    }

    private String genId(String url) {
        Integer urlInt = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).asInt();
        return this.hashGen.encode(Integer.toUnsignedLong(urlInt));
    }
}
