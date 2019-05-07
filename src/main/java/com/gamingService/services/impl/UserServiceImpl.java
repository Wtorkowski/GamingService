package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
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
    private LoggedUser loggedUser;

//    @Override
//    public User currentUserEntity() {
//        String userNameDTO = loggedUser.value().getUserName();
//        return userRepository.findByUserName(userNameDTO);
//    }

//    @Override
//    public UserDTO getLoggedUser() {
//       return null;
//    }

    @Override
    public void registerUser(RegistrationFormDTO registrationFormDTO) {
        User userToRegister = ConverterFactory.fromResourceToUser(registrationFormDTO);
        userRepository.save(userToRegister);
    }

    @Override
    public boolean isRepeatPasswordEqual(RegistrationFormDTO registrationFormDTO) {
        return registrationFormDTO.getPassword().equals(registrationFormDTO.getRepeatPassword());
    }

}
