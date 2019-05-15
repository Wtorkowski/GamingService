package com.gamingService.core.components;

import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.UserRepository;
import com.gamingService.dto.UserDTO;
import com.gamingService.services.converters.ConverterFactory;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {

    private UserRepository userRepository;
    private UserDTO user;

    public LoggedUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO value() {
        if (user == null) {
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                org.springframework.security.core.userdetails.User securityUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
                String username = securityUser.getUsername();
                User userEntity = userRepository.findByUserName(username);
                this.user = ConverterFactory.convertUserToDTO(userEntity);
            } else {
                this.user = null;
            }
        }
        return user;
    }

    public User currentUserEntity() {
        String userNameDTO = value().getUserName();
        return userRepository.findByUserName(userNameDTO);
    }

}