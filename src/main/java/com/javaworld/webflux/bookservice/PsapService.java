package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PsapService {


    Mono<Psap> findById(String id);

    Mono<Psap> findByState(String state);

    Flux<Psap> findAll();

    Mono<Psap> save(Psap psap);

    Mono<Void> deleteById(String id);

}
