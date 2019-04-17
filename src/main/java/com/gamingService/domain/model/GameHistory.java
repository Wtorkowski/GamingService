package com.gamingService.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Duration;

@Entity
@Table(name = "games_history")
public class GameHistory extends AbstractEntity {

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private Duration duration;

    //Field used in Mastermind game.
    private int attempts;

    public GameHistory(){}

    public GameHistory(User user, String gameName, String difficulty, Duration duration, int attempts) {
        this.user = user;
        this.gameName = gameName;
        this.difficulty = difficulty;
        this.duration = duration;
        this.attempts = attempts;
    }

    public User getUser() {
        return user;
    }

    public GameHistory setUser(User user) {
        this.user = user;
        return this;
    }

    public String getGameName() {
        return gameName;
    }

    public GameHistory setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public GameHistory setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Duration getDuration() {
        return duration;
    }

    public GameHistory setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public int getAttempts() {
        return attempts;
    }

    public GameHistory setAttempts(int attempts) {
        this.attempts = attempts;
        return this;
    }
}
