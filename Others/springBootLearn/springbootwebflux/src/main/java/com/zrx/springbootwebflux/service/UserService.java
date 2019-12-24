package com.zrx.springbootwebflux.service;

import com.zrx.springbootwebflux.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * UserService
 * <p>
 * Data
 * 2019/12/24 21:32
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class UserService {

    public Flux<User> findAll() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return Flux.fromIterable(MAP.values());
    }

    public Mono<User> getById(Long id){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return Mono.justOrEmpty(MAP.get(String.valueOf(id)));
    }




    private static final Map<String, User> MAP = new HashMap<>();

    static {
        MAP.put("1",new User("1","A"));
        MAP.put("2",new User("1","B"));
        MAP.put("3",new User("1","C"));
        MAP.put("4",new User("1","D"));
        MAP.put("5",new User("1","E"));
        MAP.put("6",new User("1","F"));
        MAP.put("7",new User("1","G"));
        MAP.put("8",new User("1","H"));
    }

}
