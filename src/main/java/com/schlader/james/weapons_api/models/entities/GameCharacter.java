package com.schlader.james.weapons_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("weapons")
public class GameCharacter {

    @Id
    @GeneratedValue
    private Long characterId;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Weapon> weapons;
}
