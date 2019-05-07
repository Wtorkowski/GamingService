package com.gamingService.services.converters;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.GamesHistory;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.dto.MastermindLastGameHistoryDTO;
import com.gamingService.dto.MastermindTopScoresDTO;
import com.gamingService.dto.RegistrationFormDTO;
import com.gamingService.dto.UserDTO;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class ConverterFactory {

    public static List<MastermindTopScoresDTO> mastermindTopScoreConverter(List<GamesHistory> gamesHistoryList) {
        return gamesHistoryList.stream()
                .map(g -> new MastermindTopScoresDTO(
                        ConverterFactory.formatSecondsToDisplay(g.getDuration()),
                        g.getAttempts(),
                        g.getUser(),
                        ConverterFactory.formatDateToDisplay(g.getUpdated())))
                .collect(Collectors.toList());
    }

    private static String formatDateToDisplay(LocalDateTime localDateTime) {
        String pattern = "d MMM yyyy  HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    public static UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static MastermindAttempts fromResourcesToMastermindAttempts(String feedback,
                                                                       Decription decription,
                                                                       User user) {
        MastermindAttempts attempt = new MastermindAttempts();
        attempt.setDecriptionAttempt(decription.getDecription());
        attempt.setFeedback(feedback);
        attempt.setUser(user);
        return attempt;
    }

    public static User fromResourceToUser(RegistrationFormDTO registrationFormDTO) {
        User user = new User();
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setUserName(registrationFormDTO.getUserName());
        user.setPassword(passwordEncoder.encode(registrationFormDTO.getPassword()));
        user.beforeSave();
        return user;
    }

    public static GamesHistory mastermindStartGameResources(String encrypted, User user, String difficulty) {
        GamesHistory gamesHistory = new GamesHistory();
        gamesHistory.setGameName("mastermind");
        gamesHistory.setAttempts(0);
        gamesHistory.setEncrypted(encrypted);
        gamesHistory.setUser(user);
        gamesHistory.setDifficulty(difficulty);
        gamesHistory.beforeSave();
        return gamesHistory;
    }

    public static GamesHistory updateFinishedMastermind(GamesHistory gamesHistory, int attempts, long duration) {
        gamesHistory.setDuration(duration);
        gamesHistory.setAttempts(attempts);
        gamesHistory.beforeUpdate();
        return gamesHistory;
    }

    private static String formatSecondsToDisplay(Long seconds) {
        long min = seconds / 60;
        long sec = seconds % 60;
        if (min < 1) {
            return sec + "sec";
        } else {
            return min + " min " + sec + " sec";
        }
    }

    public static MastermindLastGameHistoryDTO fromGameHistoryToGameOverResources(GamesHistory gamesHistory) {
        MastermindLastGameHistoryDTO finishedGame = new MastermindLastGameHistoryDTO();
        finishedGame.setAttempts(gamesHistory.getAttempts());
        finishedGame.setDifficulty(gamesHistory.getDifficulty());
        finishedGame.setDuration(ConverterFactory.formatSecondsToDisplay(gamesHistory.getDuration()));
        finishedGame.setEncrypted(gamesHistory.getEncrypted());
        finishedGame.setUpdated(ConverterFactory.formatDateToDisplay(gamesHistory.getUpdated()));
        finishedGame.setUser(gamesHistory.getUser());
        return finishedGame;
    }
}
