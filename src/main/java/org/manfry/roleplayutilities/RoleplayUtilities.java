package org.manfry.roleplayutilities;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.manfry.roleplayutilities.commands.broadcast;
import org.manfry.roleplayutilities.commands.help;

public final class RoleplayUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.load(this);
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("Roleplay Utilities");
        Bukkit.getLogger().info("Made by: Manfry");
        Bukkit.getLogger().info("Version 1.0");
        Bukkit.getLogger().info("Plugin loaded");
        Bukkit.getLogger().info(" ");

        getCommand("broadcast").setExecutor(new broadcast());
        getCommand("help").setExecutor(new help());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("Roleplay Utilities");
        Bukkit.getLogger().info("Made by: Manfry");
        Bukkit.getLogger().info("Version 1.0");
        Bukkit.getLogger().info("Plugin unloaded");
        Bukkit.getLogger().info(" ");
    }
}