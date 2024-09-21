package com.inicio.helder.modules.user.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponse {

    private String access_token;
    private Long expires_in;
}
