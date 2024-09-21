package com.inicio.helder.modules.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UpdateUserRequest {
    @Schema(description = "User name.", example = "John Doe")
    private String name;

    @Schema(description = "User password.", example = "minhaSenha")
    private String password;

    @Schema(description = "User description.", example = "Usuario final")
    private String description;

}
