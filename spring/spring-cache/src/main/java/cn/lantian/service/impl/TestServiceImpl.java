package cn.lantian.service.impl;

import cn.lantian.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author onlyo
 * @since 2019/1/28 16:58
 */
@Service("testService")
public class TestServiceImpl implements TestService{

    @Override
    @Cacheable("ser")
    public String getId(String id) {
        return "service hello";
    }
}
