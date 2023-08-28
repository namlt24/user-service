package com.example.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Cho phép truy cập từ nguồn gốc này
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Cho phép các phương thức HTTP
                .allowedHeaders("*"); // Cho phép tất cả các header
    }
}