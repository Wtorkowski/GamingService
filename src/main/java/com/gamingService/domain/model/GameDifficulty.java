package com.gamingService.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GameDifficulty {

    private String regexp;
    private int length;
    private int bound;

    public GameDifficulty(String difficulty) {
        int codeLength = 4;
        int bound = 6;
        if (difficulty.equals("hard")) {
            codeLength = 5;
        }
        if (difficulty.equals("easy")) {
            bound = 4;
        }

        switch (difficulty) {
            case "easy": {
                this.regexp = "[1-4]{4,4}";
                this.length = codeLength;
                this.bound = bound;
                break;
            }
            case "medium": {
                this.regexp = "[1-6]{4,4}";
                this.length = codeLength;
                this.bound = bound;
                break;
            }
            case "hard": {
                this.regexp = "[1-6]{5,5}";
                this.length = codeLength;
                this.bound = bound;
                break;
            }
            default:
        }
    }
}
