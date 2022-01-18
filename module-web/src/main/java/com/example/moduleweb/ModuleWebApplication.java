package com.example.moduleweb;

import domain.member.service.MemberService;
import domain.member.service.controller.MemberController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {MemberController.class, MemberService.class})
@SpringBootApplication
public class ModuleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleWebApplication.class, args);
    }

}
