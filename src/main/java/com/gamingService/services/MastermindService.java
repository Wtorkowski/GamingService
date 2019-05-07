package com.gamingService.services;

import com.gamingService.domain.model.Decription;
import com.gamingService.domain.model.MastermindAttempts;

import java.util.List;


public interface MastermindService {

    boolean isDecriptionInputPatternCorrect(String difficulty, Decription decriptionAttemptsDTO);



    String generateFeedback(Decription decriptionDTO, String difficulty);

    void saveAttempt(Decription decription,String difficulty);

    boolean isCombinationDecrypted(Decription decriptionDTO, String difficulty);

     List<MastermindAttempts> findAllAttemptsByUserId();

    void clearAttemptsTable();

}
