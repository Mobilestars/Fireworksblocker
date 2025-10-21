package de.scholle.fireworksblocker.blocker;

import de.scholle.fireworksblocker.FireworkBlocker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class FireworkCrossbowBlocker implements Listener {

    private final FireworkBlocker plugin;

    public FireworkCrossbowBlocker(FireworkBlocker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;

        Player player = event.getPlayer();
        if (!plugin.getConfig().getBoolean("fireworkCrossbowEnabled", false)) {
            ItemStack mainHand = player.getInventory().getItemInMainHand();
            ItemStack offHand = player.getInventory().getItemInOffHand();

            if (mainHand.getType() == Material.CROSSBOW &&
                    offHand.getType() == Material.FIREWORK_ROCKET) {

                event.setCancelled(true);
                player.sendMessage("§cFeuerwerksraketen mit Armbrüsten sind deaktiviert!");
            }
        }
    }
}
