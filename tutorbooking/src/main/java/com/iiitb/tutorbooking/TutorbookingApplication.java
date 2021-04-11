package com.iiitb.tutorbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TutorbookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorbookingApplication.class, args);
    }

}
