package de.scholle.fireworksblocker;

import de.scholle.fireworksblocker.blocker.FireworkCrossbowBlocker;
import de.scholle.fireworksblocker.blocker.FireworkUseBlocker;
import org.bukkit.plugin.java.JavaPlugin;

public class FireworkBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new FireworkCrossbowBlocker(this), this);
        getServer().getPluginManager().registerEvents(new FireworkUseBlocker(this), this);

        getLogger().info("MinecraftHelden Plugin aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MinecraftHelden Plugin deaktiviert!");
    }
}
