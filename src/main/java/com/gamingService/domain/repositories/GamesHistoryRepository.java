package com.gamingService.domain.repositories;

import com.gamingService.domain.model.GamesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GamesHistoryRepository extends JpaRepository<GamesHistory, Long> {


    @Transactional
    void deleteAllByUserIdIsAndAttemptsIs(long userId, int attempts);

    @Query(value = "SELECT g.encrypted FROM GamesHistory g WHERE user.id=?1 AND difficulty =?2 AND gameName LIKE 'mastermind' AND attempts=0")
    String getEncryptedCode(long userId, String difficulty);

    GamesHistory findDistinctFirstByUserIdIsOrderByCreatedDesc(long userId);

    List<GamesHistory> findTop10ByGameNameIsAndDifficultyIsOrderByAttemptsAscDurationAsc(String gameName, String difficulty);

}
