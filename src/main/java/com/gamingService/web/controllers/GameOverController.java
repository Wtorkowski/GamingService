package com.gamingService.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("game_over")
public class GameOverController {

    @GetMapping
    public String gameFinished() {
        return "game_over";
    }
}
