package com.db.ss.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.db")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
       	SpringApplication.run(Application.class, args);
    }

}