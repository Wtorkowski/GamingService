package com.gamingService.web.controllers;

import com.gamingService.dto.GameAttemptsDTO;
import com.gamingService.services.impl.GameServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("game")
@AllArgsConstructor
public class GameController {

    private GameServiceImpl gameService;

    @GetMapping("/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        return "game";
    }

    @PostMapping("/{difficulty}")
    public String game(@PathVariable String difficulty,
                       @ModelAttribute GameAttemptsDTO gameAttemptsDTO,
                       Model model,
                       BindingResult result) {
        model.addAttribute("difficulty", difficulty);


        if (!gameService.isInputPatternCorrect(difficulty, gameAttemptsDTO)) {
            result.rejectValue("attempt","attemptPattern");
            return "game";
        }

        return "game";
    }
}
