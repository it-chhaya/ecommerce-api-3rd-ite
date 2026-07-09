package co.istad.chhaya.ecommerce.features.auth;

import co.istad.chhaya.ecommerce.features.auth.dto.RegisterRequest;
import co.istad.chhaya.ecommerce.features.auth.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);
}
