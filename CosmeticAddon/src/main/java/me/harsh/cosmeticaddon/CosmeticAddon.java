package me.harsh.cosmeticaddon;


import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDances.DragonSummoner;
import org.bukkit.event.Listener;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class CosmeticAddon extends SimplePlugin {
    public static final Map<UUID, String> playerCosmetic = new HashMap<>();

    @Override
    protected void onPluginStart() {
        VictoryDance summoner = new DragonSummoner();
    }
}
