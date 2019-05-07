package com.gamingService.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mastermind_attempts")
public class MastermindAttempts {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime created;

    @Column(nullable = false)
    private String feedback;

    @Column(nullable = false)
    @Size(min = 4, max = 5)
    private String decriptionAttempt;

    @ManyToOne
    private User user;

    @PrePersist
    public void beforeSave() {
        created = LocalDateTime.now();
    }
}

