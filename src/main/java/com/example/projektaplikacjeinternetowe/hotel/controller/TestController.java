package com.example.projektaplikacjeinternetowe.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final CacheManager cacheManager;

    @GetMapping("/cache")
    public ResponseEntity testCase() {
        var caches = cacheManager.getCacheNames();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello there!";
    }
}
