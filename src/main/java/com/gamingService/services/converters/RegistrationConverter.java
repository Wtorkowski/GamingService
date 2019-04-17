package com.gamingService.services.converters;


import com.gamingService.domain.model.User;
import com.gamingService.dto.RegistrationFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RegistrationConverter {


    private PasswordEncoder passwordEncoder;

    public RegistrationConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User fromResourceToUser(RegistrationFormDTO registrationFormDTO) {
        User user = new User();
        user.setUserName(registrationFormDTO.getUserName());
        user.setPassword(passwordEncoder.encode(registrationFormDTO.getPassword()));
        user.setCreated(LocalDateTime.now());
        return user;
    }
}
