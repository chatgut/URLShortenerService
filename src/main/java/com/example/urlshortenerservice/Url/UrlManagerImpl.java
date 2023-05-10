package com.example.urlshortenerservice.Url;

import com.google.common.hash.Hashing;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class UrlManagerImpl implements UrlManager{

    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    @Override
    public String getUrlByKey(@NotBlank String key) {
        Url url = redisTemplate.opsForValue().get(key);
        return url.getUrl();
    }

    @Override
    public Url shortenUrl(@NotBlank String url) {
        String key = Hashing.murmur3_128().hashString(url, Charset.defaultCharset()).toString();
        Url shortUrlEntry = Url.builder().Key(key).createdAt(LocalDateTime.now()).Url(url).build();

        redisTemplate.opsForValue().set(key, shortUrlEntry, 36000L, TimeUnit.SECONDS);
        return shortUrlEntry;
    }
}
