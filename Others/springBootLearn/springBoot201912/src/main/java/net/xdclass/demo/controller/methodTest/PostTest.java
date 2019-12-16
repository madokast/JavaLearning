package net.xdclass.demo.controller.methodTest;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * learn post method
 * <p>
 * Data
 * 2019/12/15 16:05
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class PostTest {

    private ThreadLocal<Map<String,Object>> mapThreadLocal = ThreadLocal.withInitial(HashMap::new);

    /**
     * 请求自动包装成pojo
     * 注意： 需要指定http头为 content-type = application/json
     *
     * url http://localhost:8080/saveuser
     * Content-Type application/json
     * body
     *      {
     * 	        "name": "zrx",
     * 	        "age": 20
     *      }
     *
     * @param user pojo
     * @return XXX
     */
    @PostMapping("/saveuser")
    public Object saveUser(@RequestBody User user){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("user",user);
        params.put("time",String.valueOf(new Date()));

        return params;
    }

    /**
     * 简单测试
     * http://localhost:8080/login
     * {
     *     "id": "12",
     *     "time": "Sun Dec 15 19:09:22 CST 2019",
     *     "pwd": "321"
     * }
     *
     * @param id id
     * @param pwd pwd
     * @return map
     */
    @PostMapping("/login")
    public Object login(String id,String pwd){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("id",id);
        params.put("pwd",pwd);
        params.put("time",String.valueOf(new Date()));

        return params;
    }
}
