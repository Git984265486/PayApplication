package com.example.ApplicationConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Path/**").addResourceLocations("D:/DevelopmentTool/Java/JavaProject/PayApplication/src/main/resources/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
