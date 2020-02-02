package com.schlader.james.weapons_api.controllers.weapons;

import com.schlader.james.weapons_api.models.entities.Weapon;
import com.schlader.james.weapons_api.services.WeaponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weapon")
public class WeaponController {

    private WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/all")
    public List<Weapon> getAllWeapons() {
        return weaponService.getAllWeapons();
    }
}
