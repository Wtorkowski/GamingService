package com.gamingService.web.controllers;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.GamesHistory;
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
        mastermindService.clearAttemptsTable();
        model.addAttribute("user", userService.currentUserDTO());
        return "mastermind/mastermind_home";
    }

    @PostMapping("/home")
    public String formRequest(@RequestParam("difficulty") String difficulty) {
        mastermindService.clearAttemptsTable();
        gamesHistoryService.deletePreviousUnfinishedGames();
        gamesHistoryService.createMastermindGameHistory(difficulty);
        return "redirect:/mastermind/game/" + difficulty;
    }

    @GetMapping("/game/{difficulty}")
    public String prepareGamePAge(@PathVariable String difficulty, Model model) {
        model.addAttribute("user",userService.currentUserDTO());
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("decription", new Decription());
        return "mastermind/mastermind_game";
    }

    @PostMapping("/game/{difficulty}")
    public String game(@PathVariable String difficulty,
                       @ModelAttribute Decription decription,
                       Model model,
                       BindingResult result) {
        model.addAttribute("user",userService.currentUserDTO());
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByUserId());
        if (!mastermindService.isDecriptionInputPatternCorrect(difficulty, decription)) {
            result.rejectValue("decription", "attemptPattern");
            return "mastermind/mastermind_game";
        }
        mastermindService.saveAttempt(decription, difficulty);
        model.addAttribute("attemptsList", mastermindService.findAllAttemptsByUserId());

        if (mastermindService.isCombinationDecrypted(decription, difficulty)) {
            return "redirect:/mastermind/game_over/" + difficulty;
        }


        //TODO remove following 2 lanes at the end of development:
        String encryptedCode = gamesHistoryService.getMastermindEncryptedCode(difficulty);
        System.out.println(encryptedCode);

        return "mastermind/mastermind_game";
    }

    @GetMapping("/game_over/{difficulty}")
    public String generateGameOverPage(@PathVariable String difficulty, Model model) {
        GamesHistory finishedGame = gamesHistoryService.updateFinishedMastermindGame();
        model.addAttribute("user",userService.currentUserDTO());
        model.addAttribute("finishedGame", gamesHistoryService.getLastMastermindGameHistoryDTO(finishedGame));
        model.addAttribute("topScores", gamesHistoryService.getTopScoresList(difficulty));
        return "mastermind/mastermind_game_over";
    }
}
