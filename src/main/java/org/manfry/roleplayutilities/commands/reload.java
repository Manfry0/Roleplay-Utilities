package org.manfry.roleplayutilities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.manfry.roleplayutilities.ConfigManager;

public class reload implements CommandExecutor {

    public reload(CommandSender s) {
        onCommand(s, null, null, null);
    }

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        ConfigManager.reload();
        s.sendMessage("§aThe plugin was successfully reloaded!");
        return true;
    }
}
