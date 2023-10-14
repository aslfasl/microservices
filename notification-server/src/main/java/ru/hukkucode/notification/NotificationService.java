package ru.hukkucode.notification;

import org.springframework.stereotype.Service;
import ru.hukkucode.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public Notification saveNotification(NotificationRequest request) {
        return notificationRepository.save(
                Notification.builder()
                        .toCustomerId(request.getToCustomerId())
                        .toCustomerEmail(request.getToCustomerEmail())
                        .sender("Me")
                        .message(request.getMessage())
                        .sendAt(LocalDateTime.now())
                        .build());
    }
}
