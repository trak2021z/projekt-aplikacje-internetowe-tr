package com.example.projektaplikacjeinternetowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProjektAplikacjeInternetoweApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektAplikacjeInternetoweApplication.class, args);
    }

}
