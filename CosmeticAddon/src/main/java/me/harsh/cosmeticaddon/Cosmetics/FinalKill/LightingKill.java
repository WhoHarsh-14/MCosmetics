package me.harsh.cosmeticaddon.Cosmetics.FinalKill;

import de.marcely.bedwars.api.event.player.PlayerKillPlayerEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.FinalKillNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LightingKill implements Listener {
    private CosmeticAddon plugin;

    public LightingKill(CosmeticAddon plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerKillEvent(PlayerKillPlayerEvent event){
        if (!event.isFatalDeath()) return;

        Player player = event.getPlayer();
        if (player.hasPermission("addon.lighting") && plugin.finalKillCosmetic.get(player.getUniqueId()).equals(FinalKillNames.LIGHTING)){
            player.getLocation().getWorld().strikeLightningEffect(player.getLocation());
        }


    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        event.getAction();
    }
}
