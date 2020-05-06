package com.schlader.james.weapons_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("characters")
public class Player {

    @Id
    @GeneratedValue
    private Long playerId;
    @Column(nullable = false)
    private String first_name;
    private String last_name;
    @Column(nullable = false)
    private String email;
    @OneToMany(mappedBy = "player", cascade = CascadeType.REMOVE)
    private Set<GameCharacter> characters;
}
