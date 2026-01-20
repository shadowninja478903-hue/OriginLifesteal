package com.example.originlifesteal;

import org.bukkit.entity.Player;
import java.util.*;

public class AntiFarm {
    private static final Map<UUID, Map<UUID, Long>> recentKills = new HashMap<>();
    private static final Map<UUID, List<Long>> victimDeaths = new HashMap<>();

    public static boolean isValid(Player killer, Player victim) {
        long now = System.currentTimeMillis();

        recentKills.putIfAbsent(killer.getUniqueId(), new HashMap<>());
        Long last = recentKills.get(killer.getUniqueId()).get(victim.getUniqueId());
        if (last != null && now - last < 600000) return false;

        victimDeaths.putIfAbsent(victim.getUniqueId(), new ArrayList<>());
        victimDeaths.get(victim.getUniqueId()).removeIf(t -> now - t > 900000);
        if (victimDeaths.get(victim.getUniqueId()).size() >= 3) return false;

        Long combat = CombatListener.lastCombat.get(victim.getUniqueId());
        if (combat == null || now - combat > 20000) return false;

        recentKills.get(killer.getUniqueId()).put(victim.getUniqueId(), now);
        victimDeaths.get(victim.getUniqueId()).add(now);
        return true;
    }
}