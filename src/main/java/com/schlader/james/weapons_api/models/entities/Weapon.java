package com.schlader.james.weapons_api.models.entities;

import com.schlader.james.weapons_api.models.dto.WeaponDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "weapons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String page;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String image;
    private String type;
    private Double overallLength;
    private Double bladeLength;
    private Double bladeWidth;
    private Double cob;
    private Double cop;
    private Double weight;
    private Double axEdgeLength;
    private Double axWarHeadDepth;

    public Weapon(WeaponDTO weaponDTO) {
        this.id = weaponDTO.getId();
        this.page = weaponDTO.getPage();
        this.name = weaponDTO.getName();
        this.image = weaponDTO.getImage();
        this.type = weaponDTO.getType();
        this.overallLength = weaponDTO.getOverallLength();
        this.bladeLength = weaponDTO.getBladeLength();
        this.bladeWidth = weaponDTO.getBladeWidth();
        this.cop = weaponDTO.getCop();
        this.cob = weaponDTO.getCob();
        this.weight = weaponDTO.getWeight();
        this.axEdgeLength = weaponDTO.getAxEdgeLength();
        this.axWarHeadDepth = weaponDTO.getAxWarHeadDepth();
    }
}
