package ru.hukkucode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.hukkucode.amqp.RabbitMQMessageProducer;
import ru.hukkucode.clients.fraud.FraudCheckResponse;
import ru.hukkucode.clients.fraud.FraudClient;
import ru.hukkucode.clients.notification.NotificationClient;
import ru.hukkucode.clients.notification.NotificationRequest;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudClient fraudClient,
        RabbitMQMessageProducer messageProducer
) {

    public void registerCustomer(CustomerRegistrationRequest req) {
        Customer customer = Customer.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response != null && response.isFraudster())
            throw new IllegalStateException("Fraudster!");

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome!", customer.getFirstName())
        );

        messageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
