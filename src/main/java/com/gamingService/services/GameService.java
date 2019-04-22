package com.gamingService.services;

import com.gamingService.dto.GameAttemptsDTO;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    boolean isInputPatternCorrect(String difficulty, GameAttemptsDTO gameAttemptsDTO);

    String generateEncryptedCode(String difficulty);

    String generateFeedback(String encryptedCode, GameAttemptsDTO gameAttemptsDTO);



}
