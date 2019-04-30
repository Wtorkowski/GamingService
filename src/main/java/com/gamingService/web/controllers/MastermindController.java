package com.gamingService.web.controllers;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.User;
import com.gamingService.services.UserService;
import com.gamingService.services.impl.MastermindServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("mastermind")
public class MastermindController {

    private MastermindServiceImpl mastermindService;
    private UserService userService;

    @GetMapping("/home")
    public String prepareMmHomePage() {
        return "mastermind_home";
    }

    @GetMapping("/game/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("decription", new Decription());
        return "mastermind";
    }

    @PostMapping("game/{difficulty}")
    public String game(@PathVariable String difficulty,
                       @ModelAttribute Decription decription,
                       Model model,
                       BindingResult result) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByCreated());

        User currentUser = userService.currentUserEntity();

        if (!mastermindService.isInputPatternCorrect(difficulty, decription)) {
            result.rejectValue("decription", "attemptPattern");
            return "mastermind";
        }

        if (mastermindService.noCurrentGame()) {
            String encryptedCode = mastermindService.generateEncryptedCode(difficulty);
            String feedback = mastermindService.generateFeedback(encryptedCode, decription, difficulty);
            mastermindService.saveAttempt(encryptedCode, feedback, decription, currentUser);

            if (mastermindService.isCombinationDecrypted(decription, encryptedCode)) {
                return "mastermind_game_over";
            }
            model.addAttribute("attemptsList", mastermindService.findAllAttemptsByCreated());
            return "mastermind";
        }
        String encryptedCode = mastermindService.getEncryptedCode();
        String feedback = mastermindService.generateFeedback(encryptedCode, decription, difficulty);
        mastermindService.saveAttempt(encryptedCode, feedback, decription, currentUser);
        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByCreated());

        if (mastermindService.isCombinationDecrypted(decription, encryptedCode)) {
            return "mastermind_game_over";
        }

        return "mastermind";
    }
}
