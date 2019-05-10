package com.gamingService.services;

import com.gamingService.dto.EditUserDetailsDTO;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;

public interface UserService {

    void registerUser(RegistrationFormDTO registrationFormDTO);

    UserDTO currentUserDTO();

    boolean checkIfValidPassword(String oldPassword);

    boolean passwordsMatch(EditUserDetailsDTO editUserDetailsDTO);

    void updatePassword(String password);
}
