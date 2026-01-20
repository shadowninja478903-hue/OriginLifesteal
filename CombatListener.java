package com.example.originlifesteal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.UUID;

public class CombatListener implements Listener {
    public static final HashMap<UUID, Long> lastCombat = new HashMap<>();

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player p) {
            lastCombat.put(p.getUniqueId(), System.currentTimeMillis());
        }
    }
}