package com.javaworld.webflux.bookservice;

import com.javaworld.webflux.bookservice.model.Psap;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PsapServiceImpl implements PsapService {

    private PsapRepository psapRepository;

    public PsapServiceImpl(PsapRepository psapRepository) {
        this.psapRepository = psapRepository;
    }

    @Override
    public Mono<Psap> findById(String id) {
        return psapRepository.findById(id);
    }

    @Override
    public Mono<Psap> findByState(String state) {
        return null;
    }

    @Override
    public Flux<Psap> findAll() {
        return psapRepository.findAll();
    }

    @Override
    public Mono<Psap> save(Psap psap) {
        return psapRepository.save(psap);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return psapRepository.deleteById(id);
    }
}
