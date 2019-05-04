package com.gamingService.services.impl;

import com.gamingService.domain.model.GamesHistory;
import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.GamesHistoryRepository;
import com.gamingService.services.GamesHistoryService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GamesHistoryServiceImpl implements GamesHistoryService {


    private GamesHistoryRepository gamesHistoryRepository;

    @Override
    public void startMastermindGame(User user, String difficulty, String encrypted) {
        GamesHistory fromResources = ConverterFactory.
                mastermindStartGameResources(encrypted, user, difficulty);
        gamesHistoryRepository.save(fromResources);
    }

    @Override
    public boolean deleteUnfinishedMastermindGames(User user, String gameName) {
        gamesHistoryRepository.deleteAllByAttemptsIsAndUserIsAndGameNameIs(0,user,"mastermind");
        return false;
    }
}
