package com.gamingService.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AbstractEntity {

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String userName;


    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<GameHistory> gamesHistory;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MastermindAttempts> mastermindAttempts;

    public User() {
    }

    public User(@Size(min = 3, max = 20) String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public List<MastermindAttempts> getMastermindAttempts() {
        return mastermindAttempts;
    }

    public User setMastermindAttempts(List<MastermindAttempts> mastermindAttempts) {
        this.mastermindAttempts = mastermindAttempts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gameHistories=" + gamesHistory +
                "} " + super.toString();
    }
}
