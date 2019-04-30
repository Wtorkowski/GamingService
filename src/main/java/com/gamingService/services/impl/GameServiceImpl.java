package com.gamingService.services.impl;

import com.gamingService.core.components.LoggedUser;
import com.gamingService.domain.model.GameDifficulty;
import com.gamingService.domain.model.MastermindAttempts;
import com.gamingService.domain.model.User;
import com.gamingService.domain.repositories.CurrentGameRepository;
import com.gamingService.dto.Decription;
import com.gamingService.dto.MastermindAttemptsDTO;
import com.gamingService.services.GameService;
import com.gamingService.services.converters.ConverterFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

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
    public void saveAttempt(MastermindAttemptsDTO mastermindAttemptsDTO,
                            Decription decriptionDTO,
                            String difficulty,
                            User user) {
        MastermindAttempts attemptToSave =
                ConverterFactory.fromResourceToAttempts(mastermindAttemptsDTO, difficulty, decriptionDTO, user);
        currentGameRepository.save(attemptToSave);
    }

    @Override
    public boolean isInputPatternCorrect(GameDifficulty gameDifficulty, Decription decriptionDTO) {
        return decriptionDTO.getDecription()
                .matches(gameDifficulty.getRegexp());
    }


    @Override
    public String generateEncryptedCode(GameDifficulty gameDifficulty) {
        StringBuilder encryptedCode = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < gameDifficulty.getLength(); i++) {
            encryptedCode.append(r.nextInt(gameDifficulty.getBound()) + 1);
        }
        return encryptedCode.toString();
    }

    @Override
    public String generateFeedback(String encryptedCode, Decription decriptionDTO, GameDifficulty gameDifficulty) {

        StringBuilder solutionKey = new StringBuilder();
        String pNumber = decriptionDTO.getDecription();
        StringBuilder randomNum = new StringBuilder(encryptedCode);
        // Checks if players digit matches generated digit in its relevant position
        for (int i = 0; i < 4; i++) {
            if (pNumber.charAt(i) == randomNum.charAt(i)) {
                randomNum.setCharAt(i, 'X');
                solutionKey.append("[X]");
            }
        }
        //Checks if there is a matching digit in different position,
        for (int j = 0; j < 4; j++) {
            if (randomNum.charAt(j) != 'X') {
                int index = randomNum.indexOf(Character.toString(pNumber.charAt(j)));
                if (index != -1) {
                    randomNum.setCharAt(index, 'O');
                    solutionKey.append("[O]");
                }
            }
        }
        //Checks for non matching digits
        for (int k = 0; k < 4; k++) {
            if (randomNum.charAt(k) != 'X' && randomNum.charAt(k) != 'O') {
                solutionKey.append("[ ]");
            }
        }
        return solutionKey.toString();
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
