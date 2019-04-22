package com.gamingService.services.impl;

import com.gamingService.dto.GameAttemptsDTO;
import com.gamingService.services.GameService;

import java.util.Arrays;
import java.util.Random;

public class GameServiceImpl implements GameService {


    @Override
    public boolean isInputPatternCorrect(String difficulty, GameAttemptsDTO gameAttemptsDTO) {
        switch (difficulty) {
            case "easy":
                return gameAttemptsDTO.getDecriptionAttempt().matches("[1-4]{4,4}");
            case "medium":
                return gameAttemptsDTO.getDecriptionAttempt().matches("[1-6]{4,4}");
            case "hard":
                return gameAttemptsDTO.getDecriptionAttempt().matches("[1-6]{5,5}");
            default:
                return false;
        }
    }

    @Override
    public String generateEncryptedCode(String difficulty) {
        int numOfDigits = 4;
        if (difficulty.equals("hard")) {
            numOfDigits = 5;
        }
        Random r = new Random();
        for (int i = 0; i < numOfDigits; i++) {

        }



    }

    @Override
    public String generateFeedback(String encryptedCode, GameAttemptsDTO gameAttemptsDTO) {
        return null;
    }
}
