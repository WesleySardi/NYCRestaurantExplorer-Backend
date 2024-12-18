package org.example.nycrestaurantexplorer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("https://nyc-restaurant-explorer-frontend.vercel.app", "https://www.uxtecnologia.com")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
