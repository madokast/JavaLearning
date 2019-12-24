package net.xdclass.demo.controller.webflux;

import net.xdclass.demo.domain.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/24 21:03
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class WebFluxController {

    @GetMapping("/webflux/{id}")
    public Mono<String> getId(@PathVariable("id") Long userId){
        return Mono.just(String.valueOf(userId));
    }

}
