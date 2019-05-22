package com.gamingService.domain.repositories;

import com.gamingService.domain.model.GamesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GamesHistoryRepository extends JpaRepository<GamesHistory, Long> {


    @Transactional
    void deleteAllByUserUsernameIsAndAttemptsIs(String username, int attempts);


    GamesHistory findDistinctFirstByUserUsernameIsOrderByCreatedDesc(String userName);

    default GamesHistory findLastGameByUser(String username) {
        return findDistinctFirstByUserUsernameIsOrderByCreatedDesc(username);
    }


    List<GamesHistory> findTop10ByGameNameIsAndDifficultyIsAndUpdatedNotNullOrderByAttemptsAscDurationAsc(String gameName, String difficulty);

    default List<GamesHistory> topTenMastermindScores(String difficulty) {
        return findTop10ByGameNameIsAndDifficultyIsAndUpdatedNotNullOrderByAttemptsAscDurationAsc("mastermind", difficulty);
    }

    //TODO fix query........
    GamesHistory findTopByUserUsernameIsAndGameNameIsAndDifficultyIsAndUpdatedNotNullOrderByAttemptsAscDurationAsc(String username, String gameName, String difficulty);

    default GamesHistory topMastermindScore(String username, String difficulty) {
        return findTopByUserUsernameIsAndGameNameIsAndDifficultyIsAndUpdatedNotNullOrderByAttemptsAscDurationAsc(username, "mastermind", difficulty);
    }


    @Query(value = "SELECT g.encrypted FROM GamesHistory g WHERE user.username=?1 AND difficulty =?2 AND gameName LIKE 'mastermind' AND attempts=0")
    String getEncryptedCode(String username, String difficulty);

    @Query("SELECT COUNT (g) FROM GamesHistory g WHERE user.username=?1")
    int sumOfUserGames(String username);

    @Query("SELECT CASE WHEN SUM (g.attempts)=NULL THEN 0 ELSE SUM (g.attempts) END FROM GamesHistory g WHERE user.username=?1 AND attempts>0")
    int sumAllUserAttempts(String userName);

    @Query("SELECT CASE WHEN SUM (g.duration)=NULL THEN 0 ELSE SUM (g.duration) END FROM GamesHistory g WHERE user.username=?1 AND duration>0")
    long getTotalDuration(String username);

    @Query("SELECT CASE WHEN COUNT (g)>0 THEN TRUE ELSE FALSE END" +
            " FROM GamesHistory g WHERE user.username=?1 AND gameName LIKE 'mastermind' AND g.difficulty=?2 AND attempts>0")
    boolean isTopScoreAvailable(String username, String difficulty);

    @Query("SELECT CASE WHEN COUNT (g)>0 THEN TRUE ELSE FALSE END" +
            " FROM GamesHistory g WHERE user.username=?1 AND attempts>0 AND gameName LIKE 'mastermind'")
    boolean anyFinishedGameExists(String username);
}
