package ru.hukkucode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "ru.hukkucode.customer",
                "ru.hukkucode.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "ru.hukkucode.clients"
)
public class CustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
