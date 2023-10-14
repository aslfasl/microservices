package ru.hukkucode.clients.notification;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sendAt;

    public NotificationRequest(Integer id, String email, String message) {
        this.toCustomerId = id;
        this.toCustomerEmail = email;
        this.message = message;
    }
}
