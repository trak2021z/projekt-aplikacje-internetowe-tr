package com.example.projektaplikacjeinternetowe.hotel.commons.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearCacheTask {

    private final CacheManager cacheManager;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void reportCurrentTime() {
        cacheManager.getCacheNames().forEach(name -> cacheManager.getCache(name).clear());
    }
}
