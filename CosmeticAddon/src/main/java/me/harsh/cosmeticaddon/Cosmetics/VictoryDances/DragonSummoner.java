package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.remain.CompMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (CompMetadata.hasTempMetadata(player, "TEST") && CosmeticAddon.playerCosmetic.get(player.getUniqueId()).equals(VictoryDanceNames.ENDER_DRAGON)){
            Location location = player.getEyeLocation();
            Fireball fireball = location.getWorld().spawn(location, Fireball.class);
            fireball.setDirection(location.getDirection());
            fireball.setYield(0);
        }
    }
    @EventHandler
    public void onHitEvent(ProjectileHitEvent event){
        if (event.getEntity() instanceof Fireball){
            Fireball fireball = (Fireball) event.getEntity();
            if (fireball.isDead() || fireball.isOnGround()){
                Location finalLocation = fireball.getLocation();
                finalLocation.getWorld().createExplosion(finalLocation, 10);
            }
        }


    }
}