package com.inicio.helder.modules.getExternal.controllers;

import com.inicio.helder.modules.getExternal.dto.catImageDto;
import com.inicio.helder.modules.getExternal.services.getCarImageService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class getCatImageController {

    private final getCarImageService catService;

    public getCatImageController(getCarImageService catService) {
        this.catService = catService;
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    @SecurityRequirement(name = "jwt_auth")
    public List<catImageDto> getCatImages(@RequestParam(defaultValue = "3") int limit) {
        return catService.getCatImages(limit);
    }
}
