package com.zrx.springbootwebflux;

import com.zrx.springbootwebflux.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@SpringBootTest(classes = {SpringbootwebfluxApplication.class})
class SpringbootwebfluxApplicationTests {

    @Test
    public void test() {

        final Mono<User> userMono = WebClient.create().get().uri("http://localhost:8080/user/1").
                accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class);

        System.out.println(userMono.block());
    }

}
