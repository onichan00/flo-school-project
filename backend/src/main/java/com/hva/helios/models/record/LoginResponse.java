package com.hva.helios.models.record;

public record LoginResponse(
        Long id,
        Long userType,
        Long approvalStatus
) {
}
