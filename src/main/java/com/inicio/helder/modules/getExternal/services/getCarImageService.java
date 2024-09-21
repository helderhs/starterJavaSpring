package com.inicio.helder.modules.getExternal.services;

import com.inicio.helder.modules.getExternal.dto.catImageDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Service
public class getCarImageService {
    private final RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(getCarImageService.class);
    public getCarImageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<catImageDto> getCatImages(int limit) {
        logger.info("****** INFO");
        logger.error("****** ERROR");
        logger.debug("****** debug");
        String url = "httpsss://api.thecatapi.com/v1/images/search?limit=" + limit;
        catImageDto[] catImages = restTemplate.getForObject(url, catImageDto[].class);
        return List.of(catImages);
    }
}
