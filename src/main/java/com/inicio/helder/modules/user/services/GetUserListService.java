package com.inicio.helder.modules.user.services;

import com.inicio.helder.commons.dto.PaginationListResponse;
import com.inicio.helder.commons.dto.PaginationListInfoResponse;
import com.inicio.helder.modules.user.entities.UserEntity;
import com.inicio.helder.modules.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetUserListService {

    private final UserRepository userRepository;

    public GetUserListService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PaginationListResponse<UserEntity> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> userPage = userRepository.findAll(pageable);

        PaginationListResponse<UserEntity> response = new PaginationListResponse<>();
        response.setPage(new PaginationListInfoResponse(page, size, userPage.getTotalElements()));
        response.setItems(userPage.getContent());

        return response;
    }
}
