package com.example.urlshortenerservice.Controller;

import com.example.urlshortenerservice.Url.Url;
import com.example.urlshortenerservice.Url.UrlManager;
import com.example.urlshortenerservice.UrlLong;
import com.example.urlshortenerservice.UrlShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/urlShortener")
public class RedisController {

    @Autowired
    UrlManager urlManager;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UrlShort> shortenUrl(@RequestBody UrlLong url, UriComponentsBuilder uriComponentsBuilder) {
        Url shortUrlEntry = urlManager.shortenUrl(url.getUrl());
        var shorturl = new UrlShort();
        shorturl.setShort_url(uriComponentsBuilder.path("urlShortener/").path(shortUrlEntry.getKey()).build().toUriString());
        return ResponseEntity.ok(shorturl);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity getUrl(@PathVariable String key) {
        String url = urlManager.getUrlByKey(key);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }
}
