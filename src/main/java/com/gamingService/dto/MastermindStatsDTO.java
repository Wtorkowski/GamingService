package com.gamingService.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MastermindStatsDTO {

    private String userName;
    private int gamesTotal;
    private String averageAttempts;
    private String durationTotal;
    private String averageDuration;
    private List<MastermindGameHistoryDTO> topScores;
}
