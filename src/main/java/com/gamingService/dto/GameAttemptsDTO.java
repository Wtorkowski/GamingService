package com.gamingService.dto;


import lombok.Data;

@Data
public class GameAttemptsDTO {

    private String difficultyLevel;

    private String feedback;

    private String encrypted;

    private String decriptionAttempt;
}
