package com.gamingService.web.controllers;

import com.gamingService.domain.model.GameDifficulty;
import com.gamingService.domain.model.User;
import com.gamingService.dto.Decription;
import com.gamingService.dto.MastermindAttemptsDTO;
import com.gamingService.services.UserService;
import com.gamingService.services.impl.GameServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("game")
public class GameController {

    private GameServiceImpl gameService;
    private UserService userService;

    @GetMapping("/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("decription", new Decription());
        return "game";
    }

    @PostMapping("/{difficulty}")
    public String game(@PathVariable String difficulty,
                       @ModelAttribute Decription decription,
                       MastermindAttemptsDTO mastermindAttemptsDTO,
                       Model model,
                       BindingResult result) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("attemptsList", gameService.findAllAttemptsByCreated());

        GameDifficulty gameDifficulty = new GameDifficulty(difficulty);

        if (!gameService.isInputPatternCorrect(gameDifficulty, decription)) {
            result.rejectValue("decription", "attemptPattern");
            return "game";
        }

        if (gameService.noCurrentGame()) {
            String encryptedCode = gameService.generateEncryptedCode(gameDifficulty);


            String feedback = gameService.generateFeedback(encryptedCode, decription, gameDifficulty);
            User currentUser = userService.userEntity();
            mastermindAttemptsDTO.setEncrypted(encryptedCode);
            mastermindAttemptsDTO.setFeedback(feedback);
            gameService.saveAttempt(mastermindAttemptsDTO, decription, difficulty, currentUser);

            if (gameService.isCombinationDecrypted(decription, encryptedCode)) {
                return "game_over";
            }

            model.addAttribute("attemptsList", gameService.findAllAttemptsByCreated());
            return "game";
        }

        String encryptedCode = gameService.getEncryptedCode();


        String feedback = gameService.generateFeedback(encryptedCode, decription, gameDifficulty);
        User currentUser = userService.userEntity();
        mastermindAttemptsDTO.setFeedback(feedback);
        mastermindAttemptsDTO.setEncrypted(encryptedCode);
        gameService.saveAttempt(mastermindAttemptsDTO, decription, difficulty, currentUser);

        model.addAttribute("attemptsList", gameService.findAllAttemptsByCreated());
        if (gameService.isCombinationDecrypted(decription, encryptedCode)) {
            return "game_over";
        }
        return "game";
    }
}
