package com.gamingService.domain.repositories;

import com.gamingService.domain.model.MastermindAttempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MastermindAttemptsRepository extends JpaRepository<MastermindAttempts, Long> {

    List<MastermindAttempts> findAllByUserIdIsOrderByCreated(long userId);

    @Transactional
    void deleteMastermindAttemptsByUserIdIs(long userId);

    int countMastermindAttemptsByUserIdIs(long userId);

    MastermindAttempts findFirstByUserIdIs(long userId);

    MastermindAttempts findFirstByUserIdIsOrderByCreatedDesc(long userId);
}