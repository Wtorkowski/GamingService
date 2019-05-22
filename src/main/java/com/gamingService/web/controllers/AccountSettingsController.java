package com.gamingService.web.controllers;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.dto.EditUserDetailsDTO;
import com.gamingService.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/account_settings")
public class AccountSettingsController {

    private UserServiceImpl userService;
    private LoggedUser loggedUser;

    @GetMapping
    String generateAccSettingsPage(Model model) {
        model.addAttribute("editDetails", new EditUserDetailsDTO());
        model.addAttribute("username", loggedUser.getName());
        return "account_settings";
    }

    @PostMapping
    String updateAccountSettings(@Valid @ModelAttribute(value = "editDetails") EditUserDetailsDTO editUserDetailsDTO, BindingResult result, Model model) {
        model.addAttribute("username", loggedUser.getName());
        if (!userService.checkIfValidPassword(editUserDetailsDTO.getOldPassword())) {
            result.rejectValue("oldPassword", null, "Wrong password!");
        }
        if (!userService.passwordsMatch(editUserDetailsDTO)) {
            result.rejectValue("password", null, "Repeated password do not match!");
        }
        if (result.hasErrors()) {
            return "account_settings";
        }
        userService.updatePassword(editUserDetailsDTO.getPassword());
        model.addAttribute("updated", true);
        return "account_settings";
    }
}
