package com.gamingService.services;

import com.gamingService.domain.model.GamesHistory;
import com.gamingService.dto.MastermindLastGameHistoryDTO;
import com.gamingService.dto.MastermindTopScoresDTO;

import java.util.List;

public interface GamesHistoryService {

    String generateEncryptedCode(String difficulty);

    void createMastermindGameHistory(String difficulty);

    void deletePreviousUnfinishedGames();

    String getMastermindEncryptedCode(String difficulty);

    GamesHistory updateFinishedMastermindGame();

    List<MastermindTopScoresDTO> getTopScoresList(String difficulty);

    void saveFinishedGame(GamesHistory gamesHistory);

    MastermindLastGameHistoryDTO getLastMastermindGameHistoryDTO(GamesHistory gamesHistory);
}
