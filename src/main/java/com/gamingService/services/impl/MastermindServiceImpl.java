package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.repositories.GamesHistoryRepository;
import com.gamingService.domain.repositories.MastermindAttemptsRepository;
import com.gamingService.services.MastermindService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MastermindServiceImpl implements MastermindService {

    private MastermindAttemptsRepository mastermindAttemptsRepository;
    private GamesHistoryRepository gamesHistoryRepository;
    private LoggedUser loggedUser;


    @Override
    public List<MastermindAttempts> findAllAttemptsByUserId() {
        return mastermindAttemptsRepository.findAllByUserIdIsOrderByCreated(loggedUser.value().getId());
    }

    @Override
    public void clearAttemptsTable() {
        mastermindAttemptsRepository.deleteMastermindAttemptsByUserIdIs(loggedUser.value().getId());
    }


    @Override
    public boolean isCombinationDecrypted(Decription decriptionDTO, String difficulty) {
        String encryptedCode = gamesHistoryRepository.getEncryptedCode(loggedUser.value().getId(), difficulty);
        return decriptionDTO.getDecription().equals(encryptedCode);
    }

    @Override
    public void saveAttempt(Decription decription, String difficulty) {
        String feedback = generateFeedback(decription, difficulty);
        MastermindAttempts attemptToSave =
                ConverterFactory.fromResourcesToMastermindAttempts(feedback, decription, loggedUser.currentUserEntity());
        mastermindAttemptsRepository.save(attemptToSave);
    }

    @Override
    public boolean isDecriptionInputPatternCorrect(String difficulty, Decription decription) {
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
    public String generateFeedback(Decription decription, String difficulty) {
        String encryptedCode = gamesHistoryRepository.getEncryptedCode(loggedUser.value().getId(), difficulty);
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

    private static int encryptedCodeLength(String difficulty) {
        int codeLength = 4;
        if (difficulty.equals("hard")) {
            codeLength = 5;
        }
        return codeLength;
    }


}
