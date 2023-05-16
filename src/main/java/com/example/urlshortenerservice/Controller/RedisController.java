package com.example.urlshortenerservice.Controller;

import com.example.urlshortenerservice.Url.Url;
import com.example.urlshortenerservice.Url.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/urlShortener")
public class RedisController {

    @Autowired
    UrlManager urlManager;

    @RequestMapping(value = "/{url}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity shortenUrl(@RequestBody String url){
        Url shortUrlEntry = urlManager.shortenUrl(url);
        return ResponseEntity.ok(shortUrlEntry);
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUrl(@PathVariable String key){
        String url = urlManager.getUrlByKey(key);
        return ResponseEntity.ok(url);
    }
}
