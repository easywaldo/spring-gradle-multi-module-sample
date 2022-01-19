package com.example.moduleweb.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"domain"})
@EnableJpaRepositories(basePackages = {"domain"})
@ComponentScan(basePackages = {"admin"})
@SpringBootApplication
public class AdminModuleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminModuleWebApplication.class, args);
    }
}
