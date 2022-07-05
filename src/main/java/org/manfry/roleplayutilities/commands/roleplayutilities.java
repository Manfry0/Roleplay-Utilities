package org.manfry.roleplayutilities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class roleplayutilities implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> argsList = Arrays.asList(args);
        if (!argsList.isEmpty()) {
            if (argsList.get(0).equalsIgnoreCase("reload")) {
                if (sender.hasPermission("roleplayu.roleplayu.reload")) {
                    new reload(sender);
                }
            } else sender.sendMessage("§c§lMESSAGE §8▶ §cNo permission.");
        }
        return true;
    }
}
