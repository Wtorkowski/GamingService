package com.gamingService.web.controllers;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.User;
import com.gamingService.services.impl.GamesHistoryServiceImpl;
import com.gamingService.services.impl.MastermindServiceImpl;
import com.gamingService.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/mastermind")
public class MastermindController {

    private GamesHistoryServiceImpl gamesHistoryService;
    private MastermindServiceImpl mastermindService;
    private UserServiceImpl userService;


    @GetMapping("/home")
    public String prepareMmHomePage(Model model) {
        return "mastermind_home";
    }

    @PostMapping("/home")
    public String formRequest(@RequestParam("difficulty") String difficulty) {
        User currentUser = userService.currentUserEntity();
        System.out.println(currentUser);
//        String encryptedCode = mastermindService.generateEncryptedCode(difficulty);
//        gamesHistoryService.startMastermindGame(currentUser, difficulty, encryptedCode);
        return "redirect:/mastermind/game/" + difficulty;
    }

    @GetMapping("/game/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("decription", new Decription());
        return "mastermind";
    }

    @PostMapping("/game/{difficulty}")
    public String game(@PathVariable String difficulty,
                       @ModelAttribute Decription decription,
                       Model model,
                       BindingResult result) {
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByCreated());


        if (!mastermindService.isInputPatternCorrect(difficulty, decription)) {
            result.rejectValue("decription", "attemptPattern");
            return "mastermind";
        }



//TODO getEncryptedCode from first input in masterind attempts
//        String encryptedCode = .getEncryptedCode();
//        String feedback = mastermindService.generateFeedback(encryptedCode, decription, difficulty);
//        mastermindService.saveAttempt(encryptedCode, feedback, decription, currentUser);
//        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByCreated());
//
//        if (mastermindService.isCombinationDecrypted(decription, encryptedCode)) {
//            return "mastermind_game_over";
//        }
        return "mastermind";
    }
}
