package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.UserRepository;
import com.gamingService.dto.EditUserDetailsDTO;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;
import com.gamingService.services.UserService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private LoggedUser loggedUser;

    @Override
    public void registerUser(RegistrationFormDTO registrationFormDTO) {
        User userToRegister = ConverterFactory.fromResourceToUser(registrationFormDTO);
        userRepository.save(userToRegister);
    }

    @Override
    public UserDTO currentUserDTO() {
        return loggedUser.value();
    }

    @Override
    public boolean checkIfValidPassword(String oldPassword) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPass = userRepository.getLoggedUserPassword(loggedUser.value().getId());
        return passwordEncoder.matches(oldPassword, encodedPass);
    }

    @Override
    public boolean passwordsMatch(EditUserDetailsDTO editUserDetailsDTO) {
        return Objects.equals(editUserDetailsDTO.getPassword(), editUserDetailsDTO.getRepeatPassword());
    }

    @Override
    public void updatePassword(String password) {
        User toUpdate = loggedUser.currentUserEntity();
        ConverterFactory.updatePassword(password, toUpdate);
        userRepository.save(toUpdate);
    }
}
