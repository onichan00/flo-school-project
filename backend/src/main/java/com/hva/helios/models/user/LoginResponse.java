package com.hva.helios.models.user;

public record LoginResponse(
        Long id,
        Boolean isAdmin,
        boolean isClient,
        boolean isSpecialist
) {
}
