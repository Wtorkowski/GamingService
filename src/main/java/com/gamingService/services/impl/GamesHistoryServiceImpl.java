package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.GamesHistory;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.repositories.GamesHistoryRepository;
import com.gamingService.domain.repositories.MastermindAttemptsRepository;
import com.gamingService.dto.MastermindGameHistoryDTO;
import com.gamingService.dto.MastermindStatsDTO;
import com.gamingService.dto.MastermindTopScoresDTO;
import com.gamingService.services.GamesHistoryService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class GamesHistoryServiceImpl implements GamesHistoryService {


    private GamesHistoryRepository gamesHistoryRepository;
    private MastermindAttemptsRepository mastermindAttemptsRepository;
    private LoggedUser loggedUser;


    @Override
    public void createMastermindGameHistory(String difficulty) {
        String encrypted = generateEncryptedCode(difficulty);
        GamesHistory fromResources = ConverterFactory.
                mastermindStartGameResources(encrypted, loggedUser.currentUserEntity(), difficulty);
        gamesHistoryRepository.save(fromResources);
    }

    @Override
    public void deletePreviousUnfinishedGames() {
        gamesHistoryRepository.deleteAllByUserIdIsAndAttemptsIs(loggedUser.value().getId(), 0);
    }

    @Override
    public String getMastermindEncryptedCode(String difficulty) {
        return gamesHistoryRepository.getEncryptedCode(loggedUser.value().getId(), difficulty);
    }

    @Override
    public GamesHistory updateFinishedMastermindGame() {
        int attempts = mastermindAttemptsRepository.countMastermindAttemptsByUserIdIs(loggedUser.value().getId());
        long duration = gameDuration();
        GamesHistory currentEntity = gamesHistoryRepository.
                findLastGameByUser(loggedUser.value().getId());
        GamesHistory readyToSave = ConverterFactory.updateFinishedMastermind(currentEntity, attempts, duration);
        gamesHistoryRepository.save(readyToSave);
        return readyToSave;
    }

    private Long gameDuration() {
        MastermindAttempts startEntity = mastermindAttemptsRepository.findFirstByUserIdIs(loggedUser.value().getId());
        MastermindAttempts endEntity = mastermindAttemptsRepository.findFirstByUserIdIsOrderByCreatedDesc(loggedUser.value().getId());
        return Duration.between(startEntity.getCreated(),
                endEntity.getCreated())
                .getSeconds();
    }

    @Override
    public List<MastermindTopScoresDTO> getTopScoresList(String difficulty) {
        List<GamesHistory> topScores = gamesHistoryRepository.
                topTenMastermindScores(difficulty);
        return ConverterFactory.mastermindTopScoreConverter(topScores);
    }

    @Override
    public MastermindGameHistoryDTO getLastMastermindGameHistoryDTO(GamesHistory gamesHistory) {
        return ConverterFactory.fromGameHistoryToDTO(gamesHistory);
    }

    @Override
    public MastermindStatsDTO getStatsToDisplay() {
        long userId = loggedUser.value().getId();
        String easy = "easy";
        String medium = "medium";
        String hard = "hard";
        int sumOfGames = gamesHistoryRepository.sumOfUserGames(userId);
        int sumOfAttempts = gamesHistoryRepository.sumAllUserAttempts(userId);
        long totalDuration = gamesHistoryRepository.getTotalDuration(userId);

        List<MastermindGameHistoryDTO> topScores = new ArrayList<>();
        if (setExistingMastermindTopScore(easy) != null) {
            topScores.add(setExistingMastermindTopScore(easy));
        }
        if (setExistingMastermindTopScore(medium) != null) {
            topScores.add(setExistingMastermindTopScore(medium));
        }
        if (setExistingMastermindTopScore(hard) != null) {
            topScores.add(setExistingMastermindTopScore(hard));
        }

        return MastermindStatsDTO.builder()
                .userName(loggedUser.value().getUserName())
                .gamesTotal(sumOfGames)
                .averageAttempts(ConverterFactory.formatDoubleToTwoDecimal((double) sumOfAttempts / (double) sumOfGames))
                .durationTotal(ConverterFactory.formatSecondsToDisplay(totalDuration))
                .averageDuration(ConverterFactory.formatSecondsToDisplay(totalDuration / sumOfGames))
                .topScores(topScores)
                .build();
    }

    private MastermindGameHistoryDTO setExistingMastermindTopScore(String difficulty) {
        long userId = loggedUser.value().getId();
        if (gamesHistoryRepository.isTopScoreAvailable(userId, difficulty)) {
            return ConverterFactory.fromGameHistoryToDTO(gamesHistoryRepository.topMastermindScore(userId, difficulty));
        }
        return null;
    }

    @Override
    public String generateEncryptedCode(String difficulty) {
        StringBuilder encryptedCode = new StringBuilder();
        int codeLength = encryptedCodeLength(difficulty);
        int bound = encryptedCodeBound(difficulty);
        Random r = new Random();
        for (int i = 0; i < codeLength; i++) {
            encryptedCode.append(r.nextInt(bound) + 1);
        }
        return encryptedCode.toString();
    }

    private int encryptedCodeBound(String difficulty) {
        int bound = 6;
        if (difficulty.equals("easy")) {
            bound = 4;
        }
        return bound;
    }

    private static int encryptedCodeLength(String difficulty) {
        int codeLength = 4;
        if (difficulty.equals("hard")) {
            codeLength = 5;
        }
        return codeLength;
    }
}
