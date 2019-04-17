package com.gamingService.web.controllers;

import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "register";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO registrationFormDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        //TODO
//        boolean usernameFree = userService.isUsernameFree(registrationForm.getUsername());
//        if (!usernameFree) {
//            result.rejectValue("username", null, "Nazwa użytkownika jest już zajęta");
//            return "registration";
//        }
        if (!userService.isRePassEqual(registrationFormDTO)) {
            result.rejectValue("password", "rePassNotEqualPass");
            return "register";
        }
        userService.registerUser(registrationFormDTO);
        model.addAttribute("registered_user_name", registrationFormDTO.getUserName());
        return "registered_successfully";
    }
}
