package com.gamingService.services;

import com.gamingService.domain.model.GamesHistory;
import com.gamingService.dto.MastermindGameHistoryDTO;
import com.gamingService.dto.MastermindTopScoresDTO;
import com.gamingService.dto.MastermindStatsDTO;

import java.util.List;

public interface GamesHistoryService {

    String generateEncryptedCode(String difficulty);

    void createMastermindGameHistory(String difficulty);

    void deletePreviousUnfinishedGames();

    String getMastermindEncryptedCode(String difficulty);

    GamesHistory updateFinishedMastermindGame();

    List<MastermindTopScoresDTO> getTopScoresList(String difficulty);

//    void saveFinishedGame(GamesHistory gamesHistory);

    MastermindGameHistoryDTO getLastMastermindGameHistoryDTO(GamesHistory gamesHistory);

//    int getSumAllUserGames();
//
//    String getAverageAttempts();
//
//    String getTotalTimePlayed();

    MastermindStatsDTO getStatsToDisplay();

    boolean isAnyGameFinished();
}
