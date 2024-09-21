package com.inicio.helder.modules.user.services;

import com.inicio.helder.commons.exceptions.errors.ResourceBadRequestException;
import com.inicio.helder.modules.user.dto.UserResponse;
import com.inicio.helder.modules.user.entities.UserEntity;
import com.inicio.helder.modules.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class CreateUserService {

    private final UserRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(final UserRepository candidateRepository, final PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse execute(final UserEntity userEntity) {
        final var existentCandidate = candidateRepository
                .findByEmail(userEntity.getEmail()).orElse(null);

        if (nonNull(existentCandidate)) {
            throw new ResourceBadRequestException("Email already exist");
        }

        final var password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
//        return candidateRepository.save(candidateEntity);
        candidateRepository.save(userEntity);

        return UserResponse.builder()
                .description(userEntity.getDescription())
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build();
    }
}
