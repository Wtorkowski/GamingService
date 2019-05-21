package com.gamingService.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "games_history")
public class GamesHistory extends AbstractEntity {

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String difficulty;

    private long duration;

    private int attempts;

    private String encrypted;



}
