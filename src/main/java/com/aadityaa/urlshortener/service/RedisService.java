package com.aadityaa.urlshortener.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void saveUrl(String shortCode, String originalUrl) {

        redisTemplate.opsForValue()
                .set(shortCode, originalUrl, Duration.ofHours(24));
    }

    public String getUrl(String shortCode) {

        return redisTemplate.opsForValue().get(shortCode);
    }
}