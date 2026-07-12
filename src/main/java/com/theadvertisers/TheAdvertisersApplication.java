package com.theadvertisers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TheAdvertisersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheAdvertisersApplication.class, args);
    }

}
