package com.gamingService.services;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MastermindService {

    boolean isInputPatternCorrect(String difficulty, Decription decriptionAttemptsDTO);

    String generateEncryptedCode(String difficulty);

    String generateFeedback(String encryptedCode, Decription decriptionDTO, String difficulty);

    boolean noCurrentGame();

    void saveAttempt(String encrypted, String feedback, Decription decription, User user);

    boolean isCombinationDecrypted(Decription decriptionDTO, String encryptedCode);

    List<MastermindAttempts> findAllAttemptsByCreated();

    String getEncryptedCode();

}
