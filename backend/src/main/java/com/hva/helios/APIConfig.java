package com.hva.helios;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class APIConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:*", "https://*.hva.nl:*","https://helios-fe-app-production.up.railway.app:*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
