package org.manfry.roleplayutilities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.manfry.roleplayutilities.main;

import java.util.Arrays;
import java.util.List;

public class roleplayutilities implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        List<String> argsList = Arrays.asList(args);
        if (!argsList.isEmpty()) {
            if (argsList.get(0).equalsIgnoreCase("reload")) {
                    new reload(s);

            }
        } else {
            s.sendMessage("Roleplay Utilities");
        }
        return true;
    }
}
