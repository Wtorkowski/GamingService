package com.gamingService.domain.repositories;

import com.gamingService.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

    @Query("SELECT CASE WHEN COUNT (u)=0 THEN TRUE ELSE FALSE END FROM User u WHERE u.userName=?1")
    boolean isUsernameAvailable(String userName);
}


