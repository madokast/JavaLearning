package net.xdclass.demo.controller.methodTest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * put delete等测试
 * <p>
 * Data
 * 2019/12/15 16:18
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class OtherMethodTest {

    private ThreadLocal<Map<String,Object>> mapThreadLocal = ThreadLocal.withInitial(HashMap::new);

    /**
     * 更新信息
     *
     * {
     *     "id": "12"
     * }
     *
     *
     * @param id id
     * @return XX
     */
    @PutMapping(path = "put")
    public Object put(String id){
        final Map<String, Object> map = mapThreadLocal.get();
        map.clear();
        map.put("id",id);
        return map;
    }

    /**
     * delete
     *
     * {
     *     "id": "12"
     * }
     *
     * @param id id
     * @return XX
     */
    @DeleteMapping(path = "del")
    public Object del(String id){
        final Map<String, Object> map = mapThreadLocal.get();
        map.clear();
        map.put("id",id);
        return map;
    }
}
