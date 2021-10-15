package me.harsh.cosmeticaddon.Events;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.event.player.SpectatorJoinArenaEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;

public class GameListener implements Listener {


    @EventHandler
    public void onSpectate(SpectatorJoinArenaEvent event){
        Player player = event.getSpectator().getPlayer();
        World world = player.getLocation().getWorld();
        Valid.checkNotNull(world);
        world.getPlayers().forEach(p -> {
            p.hidePlayer(CosmeticAddon.getInstance(), player);
            player.sendTitle(Common.colorize("&a&lYour Spectating Arena"), "Enjoy!", 2, 2, 1);
        });

    }
}
