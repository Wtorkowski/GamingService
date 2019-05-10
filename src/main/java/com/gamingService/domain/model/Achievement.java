package com.gamingService.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "achievement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Achievement extends AbstractEntity {

    @NotNull
    private String text;

    @NotNull
    private String description;

    @NotNull
    private int value;

    @ManyToMany
    private List<User> userList;
}
