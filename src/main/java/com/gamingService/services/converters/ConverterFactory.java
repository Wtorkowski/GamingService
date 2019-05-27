package com.gamingService.services.converters;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.GamesHistory;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.dto.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static MastermindAttempts fromResourcesToMastermindAttempts(String feedback,
                                                                       Decription decription,
                                                                       User user) {

        return MastermindAttempts.builder()
                .decriptionAttempt(decription.getDecription())
                .feedback(feedback)
                .user(user)
                .build();
    }

    public static User updatePassword(String password, User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        user.beforeUpdate();
        return user;
    }

    public static User fromResourceToUser(RegistrationFormDTO registrationFormDTO) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User user = User.builder()
                .username(registrationFormDTO.getUserName())
                .password(passwordEncoder.encode(registrationFormDTO.getPassword()))
                .build();
        user.beforeUpdate();
        return user;
    }

    public static GamesHistory mastermindStartGameResources(String encrypted, User user, String difficulty) {
        GamesHistory gamesHistory = GamesHistory.builder()
                .gameName("mastermind")
                .attempts(0)
                .encrypted(encrypted)
                .user(user)
                .difficulty(difficulty)
                .build();
        gamesHistory.beforeSave();
        return gamesHistory;
    }

    public static GamesHistory updateFinishedMastermind(GamesHistory gamesHistory, int attempts, long duration) {
        gamesHistory.setDuration(duration);
        gamesHistory.setAttempts(attempts);
        gamesHistory.beforeUpdate();
        return gamesHistory;
    }

    public static String formatSecondsToDisplay(long duration) {
        int totalTime = (int) duration;
        List<String> toDisplay = new ArrayList<>();
        int secInDay = 86400;
        int secInHour = 3600;
        int secInMinute = 60;
        int days = totalTime / secInDay;
        int hours = (totalTime % secInDay) / secInHour;
        int minutes = ((totalTime % secInDay) % secInHour) / secInMinute;
        int seconds = ((totalTime % secInDay) % secInHour) % secInMinute;
        toDisplay.add(timePeriodToString(days, "day"));
        toDisplay.add(timePeriodToString(hours, "hour"));
        toDisplay.add(timePeriodToString(minutes, "minute"));
        toDisplay.add(timePeriodToString(seconds, "second"));
        String result = String.join("", toDisplay);
        return result.substring(0, result.length() - 1);
    }

    private static String timePeriodToString(int timePeriod, String nameOfPeriod) {
        switch (timePeriod) {
            case 0: {
                return "";
            }
            case 1: {
                return timePeriod + " " + nameOfPeriod + " ";
            }
            default: {
                return timePeriod + " " + nameOfPeriod + "s ";
            }
        }
    }

    public static MastermindGameHistoryDTO fromGameHistoryToDTO(GamesHistory gamesHistory) {
        return MastermindGameHistoryDTO.builder()
                .attempts(gamesHistory.getAttempts())
                .difficulty(gamesHistory.getDifficulty())
                .duration(ConverterFactory.formatSecondsToDisplay(gamesHistory.getDuration()))
                .encrypted(gamesHistory.getEncrypted())
                .updated(ConverterFactory.formatDateToDisplay(gamesHistory.getUpdated()))
                .user(gamesHistory.getUser())
                .build();
    }

    public static String formatDoubleToTwoDecimal(double num) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(num);
    }
}