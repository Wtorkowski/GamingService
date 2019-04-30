package com.gamingService.domain.repositories;

import com.gamingService.domain.model.MastermindAttempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrentGameRepository extends JpaRepository<MastermindAttempts, Long> {

    List<MastermindAttempts> findAllByOrderByCreated();

    @Query(value = "SELECT CASE when (COUNT(m.id) > 0)  then false else true end " +
            "from MastermindAttempts m")
    boolean isAttemptTableEmpty();

    @Query(value = "SELECT DISTINCT m.encrypted FROM MastermindAttempts m WHERE m.user.userName=?1")
    String getEncryptedCode(String userName);

}