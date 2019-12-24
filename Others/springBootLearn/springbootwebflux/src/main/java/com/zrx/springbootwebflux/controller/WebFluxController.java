package com.zrx.springbootwebflux.controller;

import com.zrx.springbootwebflux.domain.User;
import com.zrx.springbootwebflux.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Description
 * web flux controller
 * <p>
 * Data
 * 2019/12/24 21:23
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class WebFluxController {

    private final UserService userService;

    private final Logger LOG = LoggerFactory.getLogger(WebFluxController.class);

    @Autowired
    public WebFluxController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable("id") long userId){
        LOG.info("收到getUserById请求：id=" + userId);
        LOG.info("收到getUserById请求：开始搜索");
        final Mono<User> userMono = userService.getById(userId);
        LOG.info("收到getUserById请求：搜索完成");
        return userMono;
    }

    @GetMapping(value = "/users",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAll(){
        return userService.findAll().delayElements(Duration.ofSeconds(1));
    }

}
