package com.gamingService.services;

import com.gamingService.domain.model.User;

public interface GamesHistoryService {

    boolean deleteUnfinishedMastermindGames(User user, String gameName);

    void startMastermindGame(User user, String difficulty, String encrypted);
}
