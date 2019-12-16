package net.xdclass.demo.controller.methodTest;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * 学习gat请求写法
 * <p>
 * Data
 * 2019/12/15 15:27
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class GetTest {
    private ThreadLocal<Map<String,Object>> mapThreadLocal = ThreadLocal.withInitial(HashMap::new);

    /**
     * 这个遵照 restful 协议
     * 从路径中获取字段
     * @param cityId cityId
     * @param userId userId
     * @return cityId userId
     */
    @RequestMapping(path = "/finduser/{city_id}/{user_id}" /*推荐下划线*/, method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("cityId",cityId);
        params.put("userId",userId);
        params.put("time",String.valueOf(new Date()));

        return params;
    }

    /**
     * learn GetMapping
     * @param from from
     * @param to to
     * @return form to
     */
    @GetMapping(path = "/pageuser/{from}/{to}")
    public Object pageUser(@PathVariable String from,@PathVariable String to){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("from",from);
        params.put("to",to);
        params.put("time",String.valueOf(new Date()));

        return params;
    }


    /**
     * 传统方法
     * http://localhost:8080/pageuser02?to=100&page=-100&other=1
     * 别名
     * 默认值
     * 是否必须...
     * @param from from
     * @param to to
     * @return from to
     */
    @GetMapping(path = "/pageuser02")
    public Object pageUser02(@RequestParam(defaultValue = "0" ,
            name = "page" /*别名*/,
            required = false /*必须吗*/) String from, String to){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("from",from);
        params.put("to",to);
        params.put("time",String.valueOf(new Date()));

        return params;
    }


    /**
     * 获取http header
     *
     * http://localhost:8080/getheader
     *
     * {
     *     "userAgent": "PostmanRuntime/7.20.1",
     *     "time": "Sun Dec 15 16:12:18 CST 2019"
     * }
     *
     * @param userAgent userAgent
     * @return userAgent
     */
    @GetMapping(path = "/getheader")
    public Object getHeader(@RequestHeader("User-Agent") String userAgent){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("userAgent",userAgent);
        params.put("time",String.valueOf(new Date()));

        return params;
    }


    /**
     * getRequest
     *
     * http://localhost:8080/getRequest
     *
     * {
     *     "request": "org.apache.catalina.connector.RequestFacade@1e5ea3e",
     *     "time": "Sun Dec 15 16:18:22 CST 2019"
     * }
     *
     * @param request getRequest
     * @return getRequest
     */
    @GetMapping(path = "/getRequest")
    public Object getRequest(HttpServletRequest request){
        final Map<String, Object> params = mapThreadLocal.get();
        params.clear();
        params.put("request",request.toString());
        params.put("time",String.valueOf(new Date()));

        return params;
    }

}
