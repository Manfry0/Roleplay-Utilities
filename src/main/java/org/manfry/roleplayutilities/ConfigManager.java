package org.manfry.roleplayutilities;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    protected static final Charset UTF8 = StandardCharsets.UTF_8;
    protected static Plugin pl;
    private static FileConfiguration mess;
    private static File mfile;

    private ConfigManager() {
        throw new IllegalStateException("Utility class");
    }

    public static void load(Plugin p) {
        pl = p;
        if (!p.getDataFolder().exists())
            p.getDataFolder().mkdir();
        mfile = new File(p.getDataFolder(), "Config.yml");
        if (!mfile.exists()) {
            try {
                p.saveResource("Config.yml", false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mess = YamlConfiguration.loadConfiguration(mfile);
    }

    public static void set(String path, Object value) {
        mess.set(path, value);
        try {
            mess.save(mfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String s) {
        return mess.getString(s);
    }

    public static double getDouble(String s) {
        return mess.getDouble(s);
    }

    public static boolean getBoolean(String s) {
        return mess.getBoolean(s);
    }

    public static void reload() {
        mess = YamlConfiguration.loadConfiguration(mfile);
    }

    public static String getColored(String message) {
        String prefix = ConfigManager.get(message);
        prefix = translateColorCodes(prefix);
        return prefix;
    }

    public static String translateColorCodes(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
