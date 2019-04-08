package cn.lantian.controller;

import cn.lantian.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlyo
 * @since 2019/1/28 16:29
 */
@RestController
@Slf4j
public class TestCont {

    @Autowired
    private TestService testService;


    @Cacheable("test2")
    @GetMapping("/test")
    public String getString(String id) {
        log.error("进入+++++++++++" + id);
        return "springboot cache";
    }

    @GetMapping("/ser")
    public String getSer() {
        return testService.getId("a");
    }


}
