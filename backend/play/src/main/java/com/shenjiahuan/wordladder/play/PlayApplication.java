package com.shenjiahuan.wordladder.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayApplication.class, args);
    }

}
