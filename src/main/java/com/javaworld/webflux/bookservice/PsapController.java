package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PsapController {

    private PsapService psapService;

    public PsapController(PsapService psapService) {
        this.psapService = psapService;
    }

    @CrossOrigin
    @GetMapping(value = "/psap/{id}")
    public Mono<Psap> getPsapById(@PathVariable String id) {
        return psapService.findById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/psaps", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Psap> getAllPsaps() {

        return psapService.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/psap")
    public Mono<Psap> createPsap(@RequestBody Psap psap) {
        return psapService.save(psap);
    }

}