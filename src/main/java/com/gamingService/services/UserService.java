package com.gamingService.services;

import com.gamingService.dto.RegistrationFormDTO;

public interface UserService {

    //TODO
//    boolean isUserNameAvailable(String username);

    void registerUser(RegistrationFormDTO registrationFormDTO);

    boolean isRepeatPasswordEqual(RegistrationFormDTO registrationFormDTO);

//    UserDTO getLoggedUser();

//    User currentUserEntity();

}
