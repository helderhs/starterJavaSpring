package com.inicio.helder.modules.user.controllers;

import com.inicio.helder.commons.dto.PaginationListResponse;
import com.inicio.helder.modules.user.dto.AuthUserRequest;
import com.inicio.helder.modules.user.dto.UpdateUserRequest;
import com.inicio.helder.modules.user.dto.UserResponse;
import com.inicio.helder.modules.user.entities.UserEntity;
import com.inicio.helder.modules.user.services.*;
//import com.hocinesehanine.gestao_vagas.modules.job.entities.JobEntity;
//import com.hocinesehanine.gestao_vagas.modules.job.usecases.FindJobsByFilters;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Informações do usuario")
public class UserController {

    private final CreateUserService candidateUseCase;
    private final GetUserByIdService getUserByIdService;
    private final AuthUserService authUserService;
    private final UpdateUserService updateUserService;
    private final GetUserListService getUserListService;





    public UserController(final CreateUserService candidateUseCase,
                          final GetUserByIdService getUserByIdService,
                          final AuthUserService authUserService,
                          final UpdateUserService updateUserService,
                          final GetUserListService getUserListService
                          ) {
        this.candidateUseCase = candidateUseCase;
        this.getUserByIdService = getUserByIdService;
        this.authUserService = authUserService;
        this.updateUserService = updateUserService;
        this.getUserListService = getUserListService;
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> generateAccessToken(@RequestBody AuthUserRequest authUserRequest) {
        try {
            final var token = authUserService.execute(authUserRequest);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @Operation(summary = "Cadastro de candidato", description = "Esssa função é responável por cadastrar um candidato")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserEntity.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "usuário já existe")
    })
    @PostMapping("/")
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody UserEntity userEntity) {
        try {
            final var savedCandidate = candidateUseCase.execute(userEntity);
            return ResponseEntity.ok().body(savedCandidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Operation(summary = "Perfile do candidato", description = "Esssa função é responável por buscar as informações do candidato")
    @SecurityRequirement(name = "jwt_auth")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "user not found")
    })
    public ResponseEntity<Object> getCandidate(final HttpServletRequest request, @PathVariable("id") Long idUser) {
        final var _idUser = request.getAttribute("user_id").toString();
        try {
            final var profileCandidate = getUserByIdService.execute(idUser);

            return ResponseEntity.ok().body(profileCandidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Operation(summary = "Lista de usuarios", description = "Esssa função é responável por retornar lista dos usuarios")
    @SecurityRequirement(name = "jwt_auth")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "user not found")
    })
    public ResponseEntity<Object> listUsers(
            @Parameter(description = "Número da página para a listagem")
            @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Tamanho da página")
            @RequestParam(value = "size", defaultValue = "10") int size) {

        try {
            PaginationListResponse<UserEntity> userPage = getUserListService.execute(page, size);
            return ResponseEntity.ok(userPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Operation(summary = "Update do candidato", description = "Esssa função é responável por dar update das informações do usuario")
    @SecurityRequirement(name = "jwt_auth")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserResponse.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "user not found")
    })
    public ResponseEntity<Object> updateCandidate(final HttpServletRequest request, @PathVariable("id") Long idUser, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        final var _idUser = request.getAttribute("user_id").toString();
        try {
            final var user = updateUserService.execute(idUser, updateUserRequest);

            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
