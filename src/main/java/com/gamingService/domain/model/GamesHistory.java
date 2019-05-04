package com.gamingService.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Duration;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "games_history")
public class GamesHistory extends AbstractEntity {

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String difficulty;

    private Duration duration;

    private int attempts;

    private String encrypted;

    public GamesHistory(User user, String gameName, String difficulty, Duration duration, int attempts) {
        this.user = user;
        this.gameName = gameName;
        this.difficulty = difficulty;
        this.duration = duration;
        this.attempts = attempts;
    }

}
