package com.gamingService.domain.repositories;

import com.gamingService.domain.model.MastermindAttempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MastermindAttemptsRepository extends JpaRepository<MastermindAttempts, Long> {

    List<MastermindAttempts> findAllByUserUsernameIsOrderByCreated(String userName);

    @Transactional
    void deleteMastermindAttemptsByUserUsernameIs(String userName);

    int countMastermindAttemptsByUserUsernameIs(String userName);

    MastermindAttempts findFirstByUserUsernameIs(String userName);

    MastermindAttempts findFirstByUserUsernameIsOrderByCreatedDesc(String userName);
}