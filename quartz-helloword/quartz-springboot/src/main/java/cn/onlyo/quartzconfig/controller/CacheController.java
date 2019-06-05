package cn.onlyo.quartzconfig.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlyo
 * @since 2019/1/15 16:00
 */
@RestController
@Slf4j
public class CacheController {

    @Cacheable("cache")
    @GetMapping("/cache/{id}")
    public void test(@PathVariable("id") Long id) {
        log.error("cache:" + id);
    }
}
