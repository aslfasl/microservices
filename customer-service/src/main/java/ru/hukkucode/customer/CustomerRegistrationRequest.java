package ru.hukkucode.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
