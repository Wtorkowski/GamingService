package com.gamingService.services;

import com.gamingService.domain.model.GameDifficulty;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.dto.Decription;
import com.gamingService.dto.MastermindAttemptsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    boolean isInputPatternCorrect(GameDifficulty gameDifficulty, Decription decriptionAttemptsDTO);

    String generateEncryptedCode(GameDifficulty gameDifficulty);

    String generateFeedback(String encryptedCode, Decription decriptionDTO, GameDifficulty gameDifficulty);

    boolean noCurrentGame();

    void saveAttempt(MastermindAttemptsDTO mastermindAttemptsDTO, Decription decriptionDTO, String difficulty, User user);

    boolean isCombinationDecrypted(Decription decriptionDTO, String encryptedCode);

    List<MastermindAttempts> findAllAttemptsByCreated();

    String getEncryptedCode();

}
