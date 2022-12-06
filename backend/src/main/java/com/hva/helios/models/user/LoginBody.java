package com.hva.helios.models.user;

public record LoginBody(
        String email,
        String password
) {
}
