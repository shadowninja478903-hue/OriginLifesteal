package com.example.originlifesteal;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class OriginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;
        if (args.length != 1) {
            player.sendMessage("§c/origin <human|blazeborn|merling|phantom|elytrian|enderian|endorian>");
            return true;
        }
        OriginManager.setOrigin(player.getUniqueId(), args[0].toLowerCase());
        player.sendMessage("§aOrigin set to §e" + args[0]);
        return true;
    }
}