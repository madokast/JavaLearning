package net.xdclass.demo.controller.redisTest;

import net.xdclass.demo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * redis测试
 * <p>
 * Data
 * 2019/12/21 16:37
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/get")
    public Object get(@RequestParam String key){

        final String get = redisTemplate.opsForValue().get(key);

        return JsonData.bulidSuccess(get);
    }

    @Autowired
    public RedisController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
