package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.CurrentGameRepository;
import com.gamingService.services.MastermindService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MastermindServiceImpl implements MastermindService {

    private CurrentGameRepository currentGameRepository;
    private LoggedUser loggedUser;

    @Override
    public String getEncryptedCode() {
        String userName = loggedUser.value().getUserName();
        return currentGameRepository.getEncryptedCode(userName);
    }

    @Override
    public List<MastermindAttempts> findAllAttemptsByCreated() {
        return currentGameRepository.findAllByOrderByCreated();
    }

    @Override
    public boolean isCombinationDecrypted(Decription decriptionDTO, String encryptedCode) {
        return decriptionDTO.getDecription().equals(encryptedCode);
    }

    @Override
    public void saveAttempt(String encrypted,
                            String feedback,
                            Decription decription,
                            User user) {
        MastermindAttempts attemptToSave =
                ConverterFactory.fromResourcesToAttempts(encrypted, feedback, decription, user);
        currentGameRepository.save(attemptToSave);
    }

    @Override
    public boolean isInputPatternCorrect(String difficulty, Decription decription) {
        String regexp = decriptionRegexp(difficulty);
        return decription.getDecription().matches(regexp);
    }

    private String decriptionRegexp(String difficulty) {
        switch (difficulty) {
            case "easy": {
                return "[1-4]{4,4}";
            }
            case "medium": {
                return "[1-6]{4,4}";
            }
            case "hard": {
                return "[1-6]{5,5}";
            }
            default:
                return null;
        }
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

    @Override
    public String generateFeedback(String encryptedCode, Decription decription, String difficulty) {

        StringBuilder feedback = new StringBuilder();
        StringBuilder encrypted = new StringBuilder(encryptedCode);
        String playersAttempt = decription.getDecription();
        int codeLength = encryptedCodeLength(difficulty);

        // Checks if players digit matches generated digit in its relevant position
        for (int i = 0; i < codeLength; i++) {
            if (playersAttempt.charAt(i) == encrypted.charAt(i)) {
                encrypted.setCharAt(i, 'X');
                feedback.append("[X]");
            }
        }
        //Checks if there is a matching digit in different position,
        for (int j = 0; j < codeLength; j++) {
            if (encrypted.charAt(j) != 'X') {
                int index = encrypted.indexOf(Character.toString(playersAttempt.charAt(j)));
                if (index != -1) {
                    encrypted.setCharAt(index, 'O');
                    feedback.append("[O]");
                }
            }
        }
        //Checks for non matching digits
        for (int k = 0; k < codeLength; k++) {
            if (encrypted.charAt(k) != 'X' && encrypted.charAt(k) != 'O') {
                feedback.append("[ ]");
            }
        }
        return feedback.toString();
    }

    private int encryptedCodeLength(String difficulty) {
        int codeLength = 4;
        if (difficulty.equals("hard")) {
            codeLength = 5;
        }
        return codeLength;
    }

    @Override
    public boolean noCurrentGame() {
        return currentGameRepository.isAttemptTableEmpty();
    }

    private Map<Integer, String> codeToMap(String code) {
        Map<Integer, String> stringToMap = new HashMap<>();
        Arrays.stream(code.split(""))
                .forEach(c -> stringToMap.put(stringToMap.size(), c));
        return stringToMap;
    }
}
