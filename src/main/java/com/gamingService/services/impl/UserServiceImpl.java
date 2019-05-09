package com.gamingService.services.impl;

import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.UserRepository;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.services.UserService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void registerUser(RegistrationFormDTO registrationFormDTO) {
        User userToRegister = ConverterFactory.fromResourceToUser(registrationFormDTO);
        userRepository.save(userToRegister);
    }
}
