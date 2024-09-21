package com.inicio.helder.modules.user.services;

import com.inicio.helder.exceptions.errors.ResourceNotFoundException;
import com.inicio.helder.modules.user.dto.UserResponse;
import com.inicio.helder.modules.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdService {

    private final UserRepository candidateRepository;

    public GetUserByIdService(UserRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public UserResponse execute(final Long userId) {
        final var user = candidateRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .description(user.getDescription())
                .build();
    }
}
