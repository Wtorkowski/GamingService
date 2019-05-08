package com.gamingService.services;

import com.gamingService.dto.RegistrationFormDTO;

public interface UserService {

    void registerUser(RegistrationFormDTO registrationFormDTO);

    boolean userExistsInDb(String username);
}
