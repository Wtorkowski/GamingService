package com.gamingService.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("game")
public class GameController {

    @GetMapping("/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        return "game";
    }

    @PostMapping("/{difficulty}")
    public String game(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        return "game";
    }
}
