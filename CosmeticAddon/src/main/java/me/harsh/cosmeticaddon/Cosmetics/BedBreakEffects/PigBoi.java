package me.harsh.cosmeticaddon.Cosmetics.BedBreakEffects;

import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.event.arena.ArenaBedBreakEvent;
import me.harsh.cosmeticaddon.CosmeticAddon;
import me.harsh.cosmeticaddon.Cosmetics.BedBreakNames;
import org.bukkit.Location;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mineacademy.fo.Common;

public class PigBoi implements Listener {
    private final CosmeticAddon plugin;
    private Integer coundown = 0;

    public PigBoi(CosmeticAddon plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBedBreak(ArenaBedBreakEvent event){
        Player player = event.getPlayer();
        Arena arena = event.getArena();
        if (player.hasPermission("addon.pigfly") && plugin.bedbreakCosmetic.get(player.getUniqueId()).equals(BedBreakNames.PIGBOI)){
            Location location = event.getBedLocation();
            Pig pig = location.getWorld().spawn(location, Pig.class);
            pig.setSaddle(true);
            pig.setVelocity(player.getEyeLocation().getDirection().rotateAroundY(90).multiply(2));
            Common.runTimer(20, () -> {
                coundown++;
                if (coundown == 2){
                    pig.remove();
                    coundown = 0;
                }
            });
        }
    }
}
