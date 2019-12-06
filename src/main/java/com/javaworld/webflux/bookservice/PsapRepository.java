package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PsapRepository extends ReactiveMongoRepository<Psap, String> {

    Flux<Psap> findAllByProperties_STATE(String state);

}
