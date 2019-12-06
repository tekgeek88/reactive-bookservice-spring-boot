package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import org.apache.coyote.Response;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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
        return psapService.findAll().delayElements(Duration.ofMillis(50));
    }

//    @CrossOrigin
//    @Query("{'properties.STATE' : ?0}")
    @GetMapping(value = "/psapsByState}")
    public String getPsapsByState() {
//        System.out.println("Finding psaps by state");
//        return psapService.findAllByProperties_STATE(state);
        return "Fuck off";
    }

    @CrossOrigin
    @PostMapping(value = "/psap")
    public Mono<Psap> createPsap(@RequestBody Psap psap) {
        return psapService.save(psap);
    }

}