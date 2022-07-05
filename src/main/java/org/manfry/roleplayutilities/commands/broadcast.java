package org.manfry.roleplayutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.manfry.roleplayutilities.ConfigManager;

import java.util.Arrays;
import java.util.List;

public class broadcast implements CommandExecutor {


    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Boolean enabled = ConfigManager.getBoolean("enabled-bc");

        if (Boolean.TRUE.equals(enabled)) {

            String broadcastsend = ConfigManager.getColored("broadcast-send");
            String prefix= ConfigManager.getColored("prefix-bc");

            List<String> argsList = Arrays.asList(args);

            if (!argsList.isEmpty()) {
                StringBuilder message = new StringBuilder();
                String colormessage;

                for (String word : argsList) {
                    message.append(word).append(" ");
                }

                colormessage = ChatColor.translateAlternateColorCodes('&', message.toString());

                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    player.sendMessage(prefix + colormessage);
                }

                s.sendMessage(broadcastsend);

            } else

                s.sendMessage("You cannot send a blank broadcast!");

        }else {
            s.sendMessage("Sorry, but actualy the broadcast command is §c§lDISACTIVATED");
        }


        return true;

    }

}
