package com.acr.vehiclesensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehiclesensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesensorApplication.class, args);
    }

}
