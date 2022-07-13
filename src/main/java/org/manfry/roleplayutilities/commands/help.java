package org.manfry.roleplayutilities.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        s.sendMessage("§c§lRoleplayUtilities Command");
        s.sendMessage("§l/rpu reload $r- roleplayu.reload - Alias: /ru reload, /roleplayutilities reload, /rp reload");
        s.sendMessage("§l/rpu help $r- roleplayu.help - Alias: /ru help, /roleplayutilities help, /rp help");
        s.sendMessage("§l/helpstaff §r- roleplayu.helpstaff.see - This tells staff someone is asking for help - Alias: /h, /aiuto");
        s.sendMessage("§l/broadcast$r - roleplayu.broadcast - Alias: /a, /annuncio, /bc");
        return true;
    }
}
