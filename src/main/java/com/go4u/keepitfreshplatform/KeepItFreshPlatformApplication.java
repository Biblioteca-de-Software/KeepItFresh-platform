package com.go4u.keepitfreshplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KeepItFreshPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepItFreshPlatformApplication.class, args);
    }

}
