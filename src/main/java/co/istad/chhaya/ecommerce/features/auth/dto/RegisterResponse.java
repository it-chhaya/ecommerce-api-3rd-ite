package co.istad.chhaya.ecommerce.features.auth.dto;

import lombok.Builder;

@Builder
public record RegisterResponse(
        String userId,
        String username,
        String email,
        String firstName,
        String lastName,
        String phoneNumber
) {
}
