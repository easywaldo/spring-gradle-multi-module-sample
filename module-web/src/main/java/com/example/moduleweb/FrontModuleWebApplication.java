package com.example.moduleweb;

import domain.member.service.MemberService;
import domain.member.service.controller.MemberController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"domain"})
@EnableJpaRepositories(basePackages = {"domain"})
@ComponentScan(basePackageClasses = {MemberController.class, MemberService.class})
@SpringBootApplication()
public class FrontModuleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontModuleWebApplication.class, args);
    }

}
