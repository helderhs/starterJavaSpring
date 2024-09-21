package com.inicio.helder.modules.user.services;

import com.inicio.helder.exceptions.errors.ResourceNotFoundException;
import com.inicio.helder.modules.user.dto.UpdateUserRequest;
import com.inicio.helder.modules.user.dto.UserResponse;
import com.inicio.helder.modules.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService {

    private final UserRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserService(final UserRepository candidateRepository, final PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse execute(final Long userId, final UpdateUserRequest updateUser) {
        final var existentUser = candidateRepository
                .findById(userId).orElse(null);

        if (existentUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        Optional.ofNullable(updateUser.getName()).ifPresent(existentUser::setName);
        String password = updateUser.getPassword();
        if (password != null) existentUser.setPassword(passwordEncoder.encode(password));
        Optional.ofNullable(updateUser.getDescription()).ifPresent(existentUser::setDescription);

        candidateRepository.save(existentUser);

        return UserResponse.builder()
                .description(existentUser.getDescription())
                .email(existentUser.getEmail())
                .id(existentUser.getId())
                .name(existentUser.getName())
                .build();
    }
}
