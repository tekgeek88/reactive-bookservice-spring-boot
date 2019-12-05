package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PsapHandler {

    private final PsapService psapService;

    public PsapHandler(PsapService psapService) {
        this.psapService = psapService;
    }

    public Mono<ServerResponse> findById(ServerRequest request) {

        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(psapService.findById(id), Psap.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(psapService.findAll(), Psap.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Psap> book = request.bodyToMono(Psap.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(book.flatMap(psapService::save), Psap.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {

        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(psapService.deleteById(id), Void.class);
    }

}
