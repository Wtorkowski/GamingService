package com.gamingService.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main_menu")
public class MainMenuController {

    @GetMapping
    public String prepareMainMenuPage() {
        return "main_menu";
    }
}
