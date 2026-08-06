package com.lexlopee.sportfood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient theMealDbClient(){
        return RestClient.builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1")
                .build();
    }
}
