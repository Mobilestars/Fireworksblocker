package de.scholle.fireworksblocker.blocker;

import de.scholle.fireworksblocker.FireworkBlocker;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FireworkUseBlocker implements Listener {

    private final FireworkBlocker plugin;

    public FireworkUseBlocker(FireworkBlocker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUseFirework(PlayerInteractEvent event) {
        if (!plugin.getConfig().getBoolean("fireworkplacementallowed", false)) {
            Action action = event.getAction();
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                ItemStack item = event.getItem();
                if (item != null && item.getType() == Material.FIREWORK_ROCKET) {
                    event.setCancelled(true);
                    event.getPlayer().sendMessage("§cFeuerwerke verwenden ist derzeit deaktiviert!");
                }
            }
        }
    }
}
