package com.gamingService.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mastermind_attempts")
public class MastermindGame extends AbstractEntity {


    @Size(min = 4, max = 9)
    private String difficultyLevel;

    @Column(nullable = false)
    @Size(min = 12, max = 12)
    private String feedback;

    @Column(nullable = false)
    @Size(min = 4, max = 5)
    private String encrypted;

    @Column(nullable = false)
    @Size(min = 4, max = 5)
    private String decriptionAttempt;

    public MastermindGame() {}

    public MastermindGame(@Size(min = 4, max = 9) String difficultyLevel,
                          @Size(min = 12, max = 12) String feedback,
                          @Size(min = 4, max = 5) String encrypted,
                          @Size(min = 4, max = 5) String decription) {
        this.difficultyLevel = difficultyLevel;
        this.feedback = feedback;
        this.encrypted = encrypted;
        this.decriptionAttempt = decription;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public String getDecription() {
        return decriptionAttempt;
    }

    public void setDecription(String decription) {
        this.decriptionAttempt = decription;
    }
}
