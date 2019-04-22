package com.gamingService.services.impl;

import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.UserRepository;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.services.UserService;
import com.gamingService.services.converters.RegistrationConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RegistrationConverter registrationConverter;


    @Override
    public void registerUser(RegistrationFormDTO registrationFormDTO) {
        User userToRegister = registrationConverter.fromResourceToUser(registrationFormDTO);
        userRepository.save(userToRegister);
    }

    @Override
    public boolean isRepeatPasswordEqual(RegistrationFormDTO registrationFormDTO) {
        return registrationFormDTO.getPassword().equals(registrationFormDTO.getRepeatPassword());
    }

//TODO
//    @Override
//    public boolean isUserNameAvailable(String username) {
//        return false;
//    }

}
