package com.gamingService.web.controllers;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.services.impl.GamesHistoryServiceImpl;
import com.gamingService.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@AllArgsConstructor
@Controller
@RequestMapping("/main_menu")
public class MainMenuController {

    private GamesHistoryServiceImpl gamesHistoryService;
    private UserServiceImpl userService;
    private LoggedUser loggedUser;

    @GetMapping
    public String prepareMainMenuPage(Model model) {
        model.addAttribute("username", loggedUser.getName());
        model.addAttribute("isAnyGameHistory", gamesHistoryService.isAnyGameFinished());
        return "main_menu";
    }
}
