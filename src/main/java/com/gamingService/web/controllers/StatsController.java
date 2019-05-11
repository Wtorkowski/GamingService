package com.gamingService.web.controllers;

import com.gamingService.services.impl.GamesHistoryServiceImpl;
import com.gamingService.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
@AllArgsConstructor
public class StatsController {

    private GamesHistoryServiceImpl gamesHistoryService;
    private UserServiceImpl userService;

    @GetMapping()
    String generateStatisticPage(Model model) {
        if (gamesHistoryService.isAnyGameFinished()) {
            model.addAttribute("user",userService.currentUserDTO());
            model.addAttribute("statistics", gamesHistoryService.getStatsToDisplay());
            model.addAttribute("isAnyGameFinished", true);

        } else {
            model.addAttribute("isAnyGameFinished", false);
        }
        return "stats";
    }
}
