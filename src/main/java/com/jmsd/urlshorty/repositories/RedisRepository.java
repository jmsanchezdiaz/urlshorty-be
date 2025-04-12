package com.jmsd.urlshorty.repositories;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
    private final StringRedisTemplate redisTemplate;

    public RedisRepository(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void put(String clave, String valor) {
        redisTemplate.opsForValue().set(clave, valor);
    }

    public String get(String clave) {
        return redisTemplate.opsForValue().get(clave);
    }
}
