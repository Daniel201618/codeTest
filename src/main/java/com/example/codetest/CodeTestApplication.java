package com.example.codetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages ="com.example.codetest")
public class CodeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeTestApplication.class, args);
    }

}
