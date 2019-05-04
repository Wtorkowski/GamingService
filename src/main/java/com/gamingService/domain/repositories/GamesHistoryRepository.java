package com.gamingService.domain.repositories;

import com.gamingService.domain.model.GamesHistory;
import com.gamingService.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesHistoryRepository extends JpaRepository<GamesHistory, Long> {

    void deleteAllByAttemptsIsAndUserIsAndGameNameIs(int attempts, User user, String gameName);

}
