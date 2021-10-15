package me.harsh.cosmeticaddon.Cosmetics.VictoryDances;

import com.Zrips.CMI.Containers.ActionType;
import com.comphenix.protocol.PacketType;
import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompMetadata;

import javax.swing.*;
import java.util.Objects;

public class JoyStick extends VictoryDance implements Listener{


    @EventHandler
    public void onRoundEnd(RoundEndEvent event){
        event.getWinners().forEach(player -> {
            if (player.hasPermission("addon.joystick") && Objects.equals(CosmeticAddon.playerCosmetic.get(player.getUniqueId()), "joystick")){
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