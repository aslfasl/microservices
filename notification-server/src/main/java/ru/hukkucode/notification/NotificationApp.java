package ru.hukkucode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "ru.hukkucode.notification",
                "ru.hukkucode.amqp"
        }
)
@EnableEurekaClient
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }
//    this is working OK
//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig config) {
//        return args -> {
//            producer.publish(new Person("Druce", 19), config.getInternalExchange(), config.getInternalNotificationRoutingKey());
//        };
//    }
//
//    record Person(String name, int age){}
}
