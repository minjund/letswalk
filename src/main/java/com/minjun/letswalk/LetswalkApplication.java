package com.minjun.letswalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LetswalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetswalkApplication.class, args);
    }

}
