package com.gamingService.web.controllers;

import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserServiceImpl userService;

    @GetMapping("/successful/{user_name}")
    public String registrationSuccessful(@PathVariable("user_name") String userName,Model model) {
        model.addAttribute("registered_user_name", userName);
        return "registration_successful";
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
        userService.registerUser(registrationFormDTO);
        return "redirect:/register/successful/" + registrationFormDTO.getUserName();
    }
}
