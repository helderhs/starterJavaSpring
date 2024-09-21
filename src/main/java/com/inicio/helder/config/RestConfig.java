package com.inicio.helder.config;

import com.inicio.helder.interceptor.RestInterceptor;
import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.client.ClientHttpRequestInterceptor;
        import org.springframework.web.client.RestTemplate;

        import java.util.Collections;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(loggingInterceptor()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestInterceptor loggingInterceptor() {
        return new RestInterceptor();
    }
}

