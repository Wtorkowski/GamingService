package com.gamingService.domain.repositories;

import com.gamingService.domain.model.GamesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GamesHistoryRepository extends JpaRepository<GamesHistory, Long> {


    @Transactional
    void deleteAllByUserIdIsAndAttemptsIs(long userId, int attempts);


    GamesHistory findDistinctFirstByUserIdIsOrderByCreatedDesc(long userId);

    default GamesHistory findLastGameByUser(long userId) {
        return findDistinctFirstByUserIdIsOrderByCreatedDesc(userId);
    }


    List<GamesHistory> findTop10ByGameNameIsAndDifficultyIsOrderByAttemptsAscDurationAsc(String gameName, String difficulty);

    default List<GamesHistory> topTenMastermindScores(String difficulty) {
        return findTop10ByGameNameIsAndDifficultyIsOrderByAttemptsAscDurationAsc("mastermind", difficulty);
    }


    GamesHistory findTopByUserIdIsAndGameNameIsAndDifficultyIsOrderByAttemptsAscDurationAsc(long userID, String gameName, String difficulty);

    default GamesHistory topMastermindScore(long userId, String difficulty) {
        return findTopByUserIdIsAndGameNameIsAndDifficultyIsOrderByAttemptsAscDurationAsc(userId, "mastermind", difficulty);
    }


    @Query(value = "SELECT g.encrypted FROM GamesHistory g WHERE user.id=?1 AND difficulty =?2 AND gameName LIKE 'mastermind' AND attempts=0")
    String getEncryptedCode(long userId, String difficulty);

    @Query("SELECT COUNT (g) FROM GamesHistory g WHERE user.id=?1")
    int sumOfUserGames(Long userId);

    @Query("SELECT CASE WHEN SUM (g.attempts)=NULL THEN 0 ELSE SUM (g.attempts) END FROM GamesHistory g WHERE user.id=?1 AND attempts>0")
    int sumAllUserAttempts(Long userId);

    @Query("SELECT CASE WHEN SUM (g.duration)=NULL THEN 0 ELSE SUM (g.duration) END FROM GamesHistory g WHERE user.id=?1 AND duration>0")
    long getTotalDuration(Long userId);

    @Query("SELECT CASE WHEN COUNT (g)>0 THEN TRUE ELSE FALSE END" +
            " FROM GamesHistory g WHERE user.id=?1 AND gameName LIKE 'mastermind' AND g.difficulty=?2 AND attempts>0")
    boolean isTopScoreAvailable(long userId, String difficulty);

    @Query("SELECT CASE WHEN COUNT (g)>0 THEN TRUE ELSE FALSE END" +
            " FROM GamesHistory g WHERE user.id=?1 AND attempts>0 AND gameName LIKE 'mastermind'")
    boolean anyFinishedGameExists(long userId);
}
