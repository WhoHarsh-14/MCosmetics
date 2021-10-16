package me.harsh.cosmeticaddon;


import me.harsh.cosmeticaddon.Configs.ConfigYamlSettings;
import me.harsh.cosmeticaddon.Cosmetics.BedBreakNames;
import me.harsh.cosmeticaddon.Cosmetics.FinalKillNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDances.DragonSummoner;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.*;

public final class CosmeticAddon extends SimplePlugin {
    public boolean economy = false;
    public boolean mysterDust = false;
    public static final Map<UUID, VictoryDanceNames> playerCosmetic = new HashMap<>();
    public final Map<UUID, BedBreakNames> bedbreakCosmetic = new HashMap<>();
    public final Map<UUID, FinalKillNames> finalKillCosmetic = new HashMap<>();

    @Override
    protected void onPluginStart() {
        Common.log("================================================================");
        Common.log("Checking Mode Given In The Config");
    }

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Arrays.asList(ConfigYamlSettings.class);
    }
}
// * * * * * * * * *
// * * * * * * * * *
// * * * * * * * * *
// * * * * * * * * *
// * * * * * * * * *