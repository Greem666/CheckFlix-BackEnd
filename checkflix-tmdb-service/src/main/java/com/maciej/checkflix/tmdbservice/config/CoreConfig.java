package com.maciej.checkflix.tmdbservice.config;

import com.maciej.checkflix.tmdbservice.service.util.adapter.TmdbIdDtoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
