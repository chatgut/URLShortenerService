package com.example.urlshortenerservice.Url;

import jakarta.validation.constraints.NotBlank;

public interface UrlManager {

    public String getUrlByKey(@NotBlank String key);

    public Url shortenUrl(@NotBlank String url);
}
