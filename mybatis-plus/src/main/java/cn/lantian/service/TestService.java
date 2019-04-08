package cn.lantian.service;

import cn.lantian.entity.zhuanye;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author onlyo
 * @since 2019/1/21 19:21
 */
public interface TestService  {

     List<zhuanye> getList();
}
