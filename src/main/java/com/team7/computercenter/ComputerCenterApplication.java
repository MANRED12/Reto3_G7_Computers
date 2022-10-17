package com.team7.computercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.team7.computercenter.controller","com.team7.computercenter.repository","com.team7.computercenter.service"})

public class ComputerCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputerCenterApplication.class, args);
    }

}
