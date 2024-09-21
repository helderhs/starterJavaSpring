package com.inicio.helder.modules.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    @Schema(example = "911")
    private Long id;

    @Schema(example = "Alcaponi")
    private String name;

    @Schema(example = "oPoderosoChefao@email.com.it")
    private String email;

    @Schema(example = "Candidato vip")
    private String description;


}
