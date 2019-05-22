package com.gamingService.web.controllers;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.services.impl.GamesHistoryServiceImpl;
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
    private LoggedUser loggedUser;

    @GetMapping()
    String generateStatisticPage(Model model) {
        if (gamesHistoryService.isAnyGameFinished()) {
            model.addAttribute("username", loggedUser.getName());
            model.addAttribute("statistics", gamesHistoryService.getStatsToDisplay());
            model.addAttribute("isAnyGameFinished", true);

        } else {
            model.addAttribute("isAnyGameFinished", false);
        }
        return "stats";
    }
}
