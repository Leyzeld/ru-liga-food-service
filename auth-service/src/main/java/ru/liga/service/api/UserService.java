package ru.liga.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.liga.dto.RegDto;

public interface UserService {
    public ResponseEntity<String> createUser(RegDto request);
}
