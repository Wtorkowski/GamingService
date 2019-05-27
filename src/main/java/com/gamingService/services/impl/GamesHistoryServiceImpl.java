package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.EnumDifficulty;
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
        gamesHistoryRepository.deleteAllByUserUsernameIsAndAttemptsIs(loggedUser.getName(), 0);
    }

    @Override
    public String getMastermindEncryptedCode(String difficulty) {
        return gamesHistoryRepository.getEncryptedCode(loggedUser.getName(), difficulty);
    }

    @Override
    public GamesHistory updateFinishedMastermindGame() {
        int attempts = mastermindAttemptsRepository.countMastermindAttemptsByUserUsernameIs(loggedUser.getName());
        long duration = gameDuration();
        GamesHistory currentEntity = gamesHistoryRepository.findLastGameByUser(loggedUser.getName());
        GamesHistory readyToSave = ConverterFactory.updateFinishedMastermind(currentEntity, attempts, duration);
        gamesHistoryRepository.save(readyToSave);
        return readyToSave;
    }

    private Long gameDuration() {
        MastermindAttempts startEntity = mastermindAttemptsRepository.findFirstByUserUsernameIs(loggedUser.getName());
        MastermindAttempts endEntity = mastermindAttemptsRepository.findFirstByUserUsernameIsOrderByCreatedDesc(loggedUser.getName());
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
    public boolean isAnyGameFinished() {
        return gamesHistoryRepository.anyFinishedGameExists(loggedUser.getName());
    }

    @Override
    public MastermindStatsDTO getStatsToDisplay() {
        String userName = loggedUser.getName();
        int sumOfGames = gamesHistoryRepository.sumOfUserGames(userName);
        int sumOfAttempts = gamesHistoryRepository.sumAllUserAttempts(userName);
        long totalDuration = gamesHistoryRepository.getTotalDuration(userName);
        String avgAttempts = averageAttempts(sumOfGames, sumOfAttempts);
        String avgDuration = averageDuration(sumOfGames, totalDuration);
        List<MastermindGameHistoryDTO> topScores = getMastermindDifficultyTop();
        return MastermindStatsDTO.builder()
                .userName(userName)
                .gamesTotal(sumOfGames)
                .averageAttempts(avgAttempts)
                .durationTotal(ConverterFactory.formatSecondsToDisplay(totalDuration))
                .averageDuration(avgDuration)
                .topScores(topScores)
                .build();
    }


    private String averageDuration(int sumOfGames, long totalDuration) {
        if (sumOfGames == 0 || totalDuration == 0) {
            return "0";
        } else {
            int avg = (int) ((double) totalDuration / (double) sumOfGames) / 1;
            return ConverterFactory.formatSecondsToDisplay(avg);
        }
    }

    private String averageAttempts(int sumOfGames, int sumOfAttempts) {
        if (sumOfGames == 0 || sumOfAttempts == 0) {
            return "0";
        } else {
            return ConverterFactory.formatDoubleToTwoDecimal((double) sumOfAttempts / (double) sumOfGames);
        }
    }

    private List<MastermindGameHistoryDTO> getMastermindDifficultyTop() {
        String userName = loggedUser.getName();
        String easy = EnumDifficulty.EASY.toString();
        String medium = EnumDifficulty.MEDIUM.toString();
        String hard = EnumDifficulty.HARD.toString();
        List<MastermindGameHistoryDTO> topScores = new ArrayList<>();
        if (gamesHistoryRepository.isTopScoreAvailable(userName, easy)) {
            topScores.add(setExistingMastermindTopScore(easy));
        }
        if (gamesHistoryRepository.isTopScoreAvailable(userName, medium)) {
            topScores.add(setExistingMastermindTopScore(medium));
        }
        if (gamesHistoryRepository.isTopScoreAvailable(userName, hard)) {
            topScores.add(setExistingMastermindTopScore(hard));
        }
        return topScores;
    }

    private MastermindGameHistoryDTO setExistingMastermindTopScore(String difficulty) {

        if (gamesHistoryRepository.isTopScoreAvailable(loggedUser.getName(), difficulty)) {
            return ConverterFactory.fromGameHistoryToDTO(gamesHistoryRepository.topMastermindScore(loggedUser.getName(), difficulty));
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
        if (difficulty.equals(EnumDifficulty.EASY.toString())) {
            bound = 4;
        }
        return bound;
    }

    private static int encryptedCodeLength(String difficulty) {
        int codeLength = 4;
        if (difficulty.equals(EnumDifficulty.HARD.toString())) {
            codeLength = 5;
        }
        return codeLength;
    }
}
