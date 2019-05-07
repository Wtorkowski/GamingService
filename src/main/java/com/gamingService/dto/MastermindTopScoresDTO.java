package com.gamingService.dto;

import com.gamingService.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MastermindTopScoresDTO {

    private String duration;
    private int attempts;
    private User user;
    private String updated;
}
