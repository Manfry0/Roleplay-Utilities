package org.manfry.roleplayutilities.commands;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.manfry.roleplayutilities.ConfigManager;

import java.util.Arrays;
import java.util.List;

public class helpstaff implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Boolean enabled = ConfigManager.getBoolean("enabled-a");
        if (Boolean.TRUE.equals(enabled)) {
            List<String> argsList = Arrays.asList(args);
            StringBuilder message = new StringBuilder();
            for (String word : argsList) {
                message.append(word).append(" ");
            }

            String confirmationmessage = ConfigManager.getColored("confirmation-message");
            s.sendMessage(confirmationmessage);

            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player.hasPermission("roleplayu.helpstaff.see")) {
                    player.sendMessage(" ");
                    player.sendMessage("§c§lHelp request");
                    player.sendMessage("§7The player §c" + s.getName());
                    if (argsList.isEmpty())
                        player.sendMessage("§7Asked for helpstaff");
                    else
                        player.sendMessage("§7Asked for helpstaff: " + message);
                    TextComponent help1 = new TextComponent("§7Go to him clicking §chere");
                    help1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + s.getName()));
             //       setHover(help1);
                    player.spigot().sendMessage(help1);
                    player.sendMessage(" ");
                }

            }


        } else {
            s.sendMessage("Sorry, but actualy the helpstaff command is §c§lDISACTIVATED");
        }
        return true;
    }

  /*  public void setHover(TextComponent o) {
        o.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (
                new Text("§7Left click to execute this command"))));
    } */
}
