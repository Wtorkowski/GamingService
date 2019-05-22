package com.gamingService.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    @UniqueElements
    private String username;


    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<GamesHistory> gamesHistory;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MastermindAttempts> mastermindAttempts;

    @ManyToMany
    private List<Achievement> achievementsList;

    public User() {
    }

    public User(@Size(min = 3, max = 20) String userName, String password) {
        this.username = userName;
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
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gameHistories=" + gamesHistory +
                "} " + super.toString();
    }

}
