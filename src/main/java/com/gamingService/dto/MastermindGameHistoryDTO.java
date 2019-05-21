package com.gamingService.dto;

import com.gamingService.domain.model.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MastermindGameHistoryDTO {
    private User user;
    private String updated;
    private int attempts;
    private String duration;
    private String encrypted;
    private String difficulty;
}
