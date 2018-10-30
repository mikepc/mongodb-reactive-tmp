package web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/
@Configuration
@Slf4j
public class SponsoredEventRouter {

    @Bean
    public RouterFunction<ServerResponse> route(SponsoredEventHandler handler){
        log.info("got here");
        return RouterFunctions
                .route(POST("/events").and(accept(MediaType.APPLICATION_JSON)), handler::createSponsoredEvent);
    }

}
