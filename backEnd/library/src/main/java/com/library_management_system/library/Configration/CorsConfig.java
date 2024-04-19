package com.library_management_system.library.Configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Component
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342") // Add your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add your allowed methods
                .allowedHeaders("*"); // Add your allowed headers
    }
}
