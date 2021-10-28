package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Configs.StoreConfig;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;

public class JoyStick extends VictoryDance implements Listener{


    @EventHandler
    public void onRoundEnd(RoundEndEvent event){
        event.getWinners().forEach(player -> {
            StoreConfig config = new StoreConfig(player.getUniqueId());
            if (player.hasPermission("addon.joystick") && config.getDance() == VictoryDanceNames.ENDER_DRAGON){
                setItemName("&c&lJoy&b&lStick");
                setPlayer(player);
                spawnItem(CompMaterial.STICK);
            }
        });
    }
    @EventHandler
    public void onClickEvent(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        Location location = player.getLocation();
        Valid.checkNotNull(player.getItemInUse());
        if (CompMetadata.hasMetadata(player.getItemInUse(), ITEM_KEY) && action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
            player.setVelocity(player.getEyeLocation().getDirection().multiply(-5));
            location.getWorld().createExplosion(location, 3);
        }
    }
}
