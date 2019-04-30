package com.gamingService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MastermindAttemptsDTO {

    private String feedback;
    private String encrypted;
    private String decription;
}
