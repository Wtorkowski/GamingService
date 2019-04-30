package com.gamingService.services.converters;

import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.dto.Decription;
import com.gamingService.dto.MastermindAttemptsDTO;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;


public class ConverterFactory {

    public static UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static MastermindAttempts fromResourceToAttempts(MastermindAttemptsDTO mastermindAttemptsDTO,
                                                            String difficulty,
                                                            Decription decription,
                                                            User user) {
        MastermindAttempts attempt = new MastermindAttempts();
        attempt.setDifficultyLevel(difficulty);
        attempt.setDecriptionAttempt(decription.getDecription());
        attempt.setEncrypted(mastermindAttemptsDTO.getEncrypted());
        attempt.setFeedback(mastermindAttemptsDTO.getFeedback());
        attempt.setUser(user);
        return attempt;
    }

    public static User fromResourceToUser(RegistrationFormDTO registrationFormDTO) {
        User user = new User();
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setUserName(registrationFormDTO.getUserName());
        user.setPassword(passwordEncoder.encode(registrationFormDTO.getPassword()));
        user.setCreated(LocalDateTime.now());
        return user;
    }
}
