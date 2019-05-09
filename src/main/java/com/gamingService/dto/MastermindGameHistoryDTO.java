package com.gamingService.dto;

import com.gamingService.domain.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MastermindGameHistoryDTO {
    private User user;
    private String updated;
    private int attempts;
    private String duration;
    private String encrypted;
    private String difficulty;
}
