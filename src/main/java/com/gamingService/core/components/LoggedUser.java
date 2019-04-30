package com.gamingService.core.components;

import com.gamingService.dto.UserDTO;
import com.gamingService.services.UserService;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {

    private UserService userService;
    private UserDTO user;

    public LoggedUser(UserService userService) {
        this.userService = userService;
    }

    public UserDTO value() {
        if (user == null) {
            this.user = userService.getLoggedUser();
        }
        return user;
    }
}