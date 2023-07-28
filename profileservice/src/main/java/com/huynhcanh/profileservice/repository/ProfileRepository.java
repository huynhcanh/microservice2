package com.huynhcanh.profileservice.repository;

import com.huynhcanh.profileservice.data.Profile;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProfileRepository extends R2dbcRepository<Profile, Long> {
    Mono<Profile> findByEmail(String email);
}