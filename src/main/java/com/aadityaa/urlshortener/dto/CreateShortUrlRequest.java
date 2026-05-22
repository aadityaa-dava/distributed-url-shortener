package com.aadityaa.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateShortUrlRequest {

    @NotBlank(message = "URL cannot be empty")

    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Invalid URL format"
    )
    private String url;
}