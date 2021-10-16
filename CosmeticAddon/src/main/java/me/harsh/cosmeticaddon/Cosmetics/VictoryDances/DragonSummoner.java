package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DragonSummoner extends VictoryDance implements Listener {
    @EventHandler
    public void onRoundEnd(RoundEndEvent event){
        event.getWinners().forEach(player -> {
            if (player.hasPermission("addon.dragon") && CosmeticAddon.playerCosmetic.get(player.getUniqueId()).equals(VictoryDanceNames.ENDER_DRAGON)){
                setPlayer(player);
                setName(player.getName() + " 's Pet");
                spawn(EntityType.ENDER_DRAGON);
            }
        });
    }
}