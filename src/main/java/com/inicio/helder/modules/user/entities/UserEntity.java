package com.inicio.helder.modules.user.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    @Schema(example = "Jhon doe", requiredMode = Schema.RequiredMode.REQUIRED, description = "nome do usuario")
    private String name;

//    @NotBlank()
//    @Pattern(regexp = "\\S+", message = "O Campo [username] não deve conter espaço")
//    @Schema(example = "jhondoe", requiredMode = Schema.RequiredMode.REQUIRED, description = "nome do usuário do candidato")
//    private String username;

    @NotBlank()
    @Schema(example = "jhondoe@gmaill.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "email do candidato")
    @Email(message = "O Campo [email] deve conter um e-mail válido")
    private String email;

    @NotBlank()
    @Schema(example = "password1233", minLength = 8, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "senha do candidato")
    @Length(min = 6, max = 100, message = "O Campo [password] não deve conter mais que 100 caracteres, e menos que 8 caracteres")
    private String password;

    @NotBlank()
    @Schema(example = "dev java junior", requiredMode = Schema.RequiredMode.REQUIRED, description = "breve descrição do candidato")
    private String description;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
