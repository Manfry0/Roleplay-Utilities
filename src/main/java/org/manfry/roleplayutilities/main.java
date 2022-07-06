package org.manfry.roleplayutilities;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.manfry.roleplayutilities.commands.broadcast;
import org.manfry.roleplayutilities.commands.help;
import org.manfry.roleplayutilities.commands.roleplayutilities;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.load(this);
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("Roleplay Utilities");
        Bukkit.getLogger().info("Made by: Manfry");
        Bukkit.getLogger().info("Version " + this.getDescription().getVersion());
        Bukkit.getLogger().info("Plugin loaded");
        Bukkit.getLogger().info(" ");

        getCommand("broadcast").setExecutor(new broadcast());
        getCommand("help").setExecutor(new help());
        getCommand("rpu").setExecutor(new roleplayutilities());

        int pluginId = 15690; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        new UpdateChecker(this, 103143).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                getLogger().info("There is not a new update available.");
            } else {
                getLogger().info("There is a new update available, download it at  https://www.spigotmc.org/resources/roleplay-utilities.103143/");
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info("Roleplay Utilities");
        Bukkit.getLogger().info("Made by: Manfry");
        Bukkit.getLogger().info("Version " + this.getDescription().getVersion());
        Bukkit.getLogger().info("Plugin unloaded");
        Bukkit.getLogger().info(" ");
    }
}
