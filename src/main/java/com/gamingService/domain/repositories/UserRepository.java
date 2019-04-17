package com.gamingService.domain.repositories;

import com.gamingService.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //TODO
//    boolean isUsernameAvailable(String username);
}
