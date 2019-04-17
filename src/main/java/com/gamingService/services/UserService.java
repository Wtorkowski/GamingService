package com.gamingService.services;

import com.gamingService.dto.RegistrationFormDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    //TODO
//    boolean isUserNameAvailable(String username);

    void registerUser(RegistrationFormDTO registrationFormDTO);

    boolean isRePassEqual(RegistrationFormDTO registrationFormDTO);
}
