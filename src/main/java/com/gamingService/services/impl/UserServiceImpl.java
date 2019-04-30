package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.UserRepository;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;
import com.gamingService.services.UserService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private LoggedUser loggedUser;

    @Override
    public User userEntity() {
        String userNameDTO = loggedUser.value().getUserName();
        return userRepository.findByUserName(userNameDTO);
    }

    @Override
    public UserDTO getLoggedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            org.springframework.security.core.userdetails.User securityUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String username = securityUser.getUsername();
            User userEntity = userRepository.findByUserName(username);
            return ConverterFactory.convertUserToDTO(userEntity);
        }
        return null;
    }

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
