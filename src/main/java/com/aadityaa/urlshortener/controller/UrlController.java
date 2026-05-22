package com.aadityaa.urlshortener.controller;

import com.aadityaa.urlshortener.dto.CreateShortUrlRequest;
import com.aadityaa.urlshortener.dto.CreateShortUrlResponse;
import com.aadityaa.urlshortener.model.Url;
import com.aadityaa.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public CreateShortUrlResponse shortenUrl(
            @Valid @RequestBody CreateShortUrlRequest request
    ) {

        Url savedUrl = urlService.shortenUrl(request.getUrl());

        String shortUrl = "http://localhost:8080/" + savedUrl.getShortCode();

        return new CreateShortUrlResponse(
                savedUrl.getOriginalUrl(),
                shortUrl
        );
    }

    @GetMapping("/{shortCode}")
    public void redirectToOriginalUrl(
            @PathVariable String shortCode,
            HttpServletResponse response
    ) throws IOException {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        response.sendRedirect(originalUrl);
    }
}