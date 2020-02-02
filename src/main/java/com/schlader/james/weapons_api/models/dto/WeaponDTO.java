package com.schlader.james.weapons_api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeaponDTO {

    private Long id;
    private String page;
    private String name;
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
}
