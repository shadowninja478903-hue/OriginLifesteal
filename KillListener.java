package com.example.originlifesteal;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.*;

public class KillListener implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player victim = e.getEntity();
        Player killer = victim.getKiller();
        if (killer == null) return;
        if (!AntiFarm.isValid(killer, victim)) return;

        String o = OriginManager.getOrigin(killer.getUniqueId());

        switch (o) {
            case "blazeborn" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
            case "merling" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 1));
            case "phantom" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 0));
            case "elytrian" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 60, 0));
            case "enderian" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));
            case "endorian" -> killer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 60, 0));
        }
    }
}