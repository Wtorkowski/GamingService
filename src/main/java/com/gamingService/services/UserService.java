package com.gamingService.services;

import com.gamingService.domain.model.User;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    //TODO
//    boolean isUserNameAvailable(String username);

    void registerUser(RegistrationFormDTO registrationFormDTO);

    boolean isRepeatPasswordEqual(RegistrationFormDTO registrationFormDTO);

    UserDTO getLoggedUser();

    User currentUserEntity();
}
