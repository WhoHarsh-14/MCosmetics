package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import com.comphenix.protocol.PacketType;
import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.remain.CompMetadata;

public class WitherDomination extends VictoryDance implements Listener {


    @EventHandler
    public void onRoundEnd(RoundEndEvent event){
        event.getWinners().forEach(player -> {
            setPlayer(player);
            setName(player.getName() + " 's Pet");
            spawn(EntityType.WITHER);
        });
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (CompMetadata.hasTempMetadata(player, "TEST") && CosmeticAddon.playerCosmetic.get(player.getUniqueId()).equals(VictoryDanceNames.WITHER)){
            Location location = player.getEyeLocation();
            WitherSkull witherSkull = location.getWorld().spawn(location, WitherSkull.class);
            witherSkull.setVelocity(location.getDirection().multiply(5));
            witherSkull.setCharged(true);
        }
    }
    @EventHandler
    public void onLandEvent(ProjectileHitEvent event){
        if (event.getEntity() instanceof WitherSkull){
            WitherSkull skull  = (WitherSkull) event.getEntity();
            if (skull.isDead() || skull.isOnGround()){
                skull.getLocation().getWorld().createExplosion(skull.getLocation(), 3);
            }
        }

    }
}
