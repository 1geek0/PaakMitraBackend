package com.g1ee0k.paak_mitra_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "com.g1ee0k.paak_mitra_api.model")
public class PaakMitraApiApplication {

    private static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        PaakMitraApiApplication.applicationContext = SpringApplication.run(PaakMitraApiApplication.class, args);
    }

}
