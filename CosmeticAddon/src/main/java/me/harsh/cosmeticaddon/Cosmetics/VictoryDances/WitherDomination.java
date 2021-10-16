package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WitherDomination extends VictoryDance implements Listener {


    @EventHandler
    public void onRoundEnd(RoundEndEvent event){
        event.getWinners().forEach(player -> {
            setPlayer(player);
            setName(player.getName() + " 's Pet");
            spawn(EntityType.WITHER);
        });
    }
}
