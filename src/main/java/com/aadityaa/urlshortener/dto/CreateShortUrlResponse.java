package com.aadityaa.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateShortUrlResponse {

    private String originalUrl;

    private String shortUrl;
}