package com.Project.MAWMConfigMover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Project.MAWMConfigMover")
public class MawmConfigMoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MawmConfigMoverApplication.class, args);
    }
}
