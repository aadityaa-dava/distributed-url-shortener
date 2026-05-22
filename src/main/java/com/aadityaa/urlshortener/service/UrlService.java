package com.aadityaa.urlshortener.service;

import com.aadityaa.urlshortener.model.Url;
import com.aadityaa.urlshortener.repository.UrlRepository;
import com.aadityaa.urlshortener.util.Base62Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aadityaa.urlshortener.exception.UrlNotFoundException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final RedisService redisService;

    public Url shortenUrl(String originalUrl) {

        Url url = Url.builder()
                .originalUrl(originalUrl)
                .createdAt(LocalDateTime.now())
                .build();

        // Save first to generate ID
        Url savedUrl = urlRepository.save(url);

        // Generate Base62 short code
        String shortCode = Base62Encoder.encode(savedUrl.getId());

        savedUrl.setShortCode(shortCode);

        return urlRepository.save(savedUrl);
    }

    public String getOriginalUrl(String shortCode) {

        // STEP 1: Check Redis Cache
        String cachedUrl = redisService.getUrl(shortCode);

        if (cachedUrl != null) {

            System.out.println("CACHE HIT");

            return cachedUrl;
        }

        System.out.println("CACHE MISS");

        // STEP 2: Fetch from DB
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException("Short URL not found"));

        Long currentCount = url.getClickCount() == null ? 0 : url.getClickCount();

        url.setClickCount(currentCount + 1);

        urlRepository.save(url);

        // STEP 3: Save into Redis
        redisService.saveUrl(shortCode, url.getOriginalUrl());

        return url.getOriginalUrl();
    }
}