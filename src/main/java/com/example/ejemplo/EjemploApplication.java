package com.example.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EjemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjemploApplication.class, args);
    }

    @Configuration
    public class Config implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry cors) {
            cors.addMapping("/**").allowedMethods("*");
        }
    }
}