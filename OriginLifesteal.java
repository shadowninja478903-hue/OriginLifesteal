package com.example.originlifesteal;

import org.bukkit.plugin.java.JavaPlugin;

public class OriginLifesteal extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("origin").setExecutor(new OriginCommand());
        getServer().getPluginManager().registerEvents(new KillListener(), this);
        getServer().getPluginManager().registerEvents(new CombatListener(), this);
    }
}