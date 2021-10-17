package me.harsh.cosmeticaddon;


import com.sun.org.apache.xpath.internal.operations.Mod;
import me.harsh.cosmeticaddon.Configs.ConfigYamlSettings;
import me.harsh.cosmeticaddon.Cosmetics.BedBreakNames;
import me.harsh.cosmeticaddon.Cosmetics.FinalKillNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDanceNames;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDance;
import me.harsh.cosmeticaddon.Cosmetics.VictoryDances.DragonSummoner;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.*;

public final class CosmeticAddon extends SimplePlugin {
    public static String MODE;
    private static Economy econ = null;
    public static final Map<UUID, VictoryDanceNames> playerCosmetic = new HashMap<>();
    public final Map<UUID, BedBreakNames> bedbreakCosmetic = new HashMap<>();
    public final Map<UUID, FinalKillNames> finalKillCosmetic = new HashMap<>();

    @Override
    protected void onPluginStart() {
        Common.log("================================================================");
        Common.log("Checking Mode Given In The Config");
        switch (ConfigYamlSettings.MODE) {
            case "eco":
                MODE = "eco";
                Common.log("Economy Found Loading Vault");
                if (!setupEconomy() ) {
                    Common.log(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
                    getServer().getPluginManager().disablePlugin(this);
                    return;
                }
                break;
            case "md":
                MODE = "md";
                Common.log("Mystery Dust Found Loading GadgetMenu");
                break;
        }
        Common.log("Loaded Cosmetic Addon");
        Common.log("==================================================================");
    }

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Arrays.asList(ConfigYamlSettings.class);
    }

    public static String getMode(){
        return MODE;
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    public static Economy getEconomy() {
        return econ;
    }
}