package com.inicio.helder.modules.user.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.inicio.helder.exceptions.errors.UnauthorizedException;
import com.inicio.helder.modules.user.dto.AuthUserRequest;
import com.inicio.helder.modules.user.dto.AuthUserResponse;
import com.inicio.helder.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class AuthUserService {

    private final UserRepository candidateRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwtCandidate.secret}")
    private String secret;

    public AuthUserService(final UserRepository candidateRepository, final PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthUserResponse execute(final AuthUserRequest authUserRequest) {
        var candidate = candidateRepository.findByEmail(authUserRequest.email()).orElseThrow(() -> new UsernameNotFoundException("Campo email ou password esta incorreto"));

        final var passwordMatches = passwordEncoder.matches(authUserRequest.password(), candidate.getPassword());

        if (!passwordMatches) {
            throw new UnauthorizedException("Access Denied");
        }

        final Algorithm algorithm = Algorithm.HMAC256(secret);
        final var expiresIn = Instant.now().plus(Duration.ofMinutes(500));
        final var token = JWT.create().withIssuer("api inicio")
                .withExpiresAt(expiresIn)
                .withClaim("roles", List.of("CANDIDATE"))
                .withSubject(candidate.getId().toString())
                .sign(algorithm);

        return AuthUserResponse.builder().access_token(token).expires_in(expiresIn.toEpochMilli()).build();
    }
}
