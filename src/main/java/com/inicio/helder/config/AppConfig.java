package com.inicio.helder.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
