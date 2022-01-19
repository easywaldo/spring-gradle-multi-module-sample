package com.example.moduleweb;


import admin.member.controller.MemberController;
import admin.member.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {MemberController.class, MemberService.class})
@SpringBootApplication
public class AdminModuleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminModuleWebApplication.class, args);
    }
}
