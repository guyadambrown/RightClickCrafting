package xyz.guyb.rightclickcrafting;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("Enabled RightClickCrafting");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("RightClickCrafting.use")) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR) {
                if (player.getInventory().getItemInMainHand().getType()== Material.WORKBENCH || player.getInventory().getItemInOffHand().getType()== Material.WORKBENCH) {
                    player.openWorkbench(null, true);
                }
            }
        }
    }
}
