package com.javaworld.webflux.bookservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PsapRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PsapHandler handler) {
        return RouterFunctions
                .route(GET("/fpsaps").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)

                .andRoute(GET("/fpsap/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)

                .andRoute(POST("/fpsap").and(accept(MediaType.APPLICATION_JSON)), handler::save)

                .andRoute(DELETE("/fpsap/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}